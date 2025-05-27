package com.study.xiaohashu.auth.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.study.framework.common.exception.BizException;
import com.study.framework.common.response.Response;
import com.study.xiaohashu.auth.constant.RedisKeyConstants;
import com.study.xiaohashu.auth.enums.ResponseCodeEnum;
import com.study.xiaohashu.auth.model.vo.veriticationcode.SendVeriticationCodeReqVO;
import com.study.xiaohashu.auth.service.VerificationCodeService;
import com.study.xiaohashu.auth.sms.AliyunSmsHelper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName VerificationCodeServiceImpl
 * @Description TODO
 * @Author zhang
 * @Date 2025/1/21
 * @Version 1.0
 **/
@Service
@Slf4j
public class VerificationCodeServiceImpl implements VerificationCodeService {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    //注意：通过 @Resource 注解注入 ThreadPoolTaskExecutor 线程池时，需要指定 name = "taskExecutor" , 否则可能会报错。
    @Resource
    private AliyunSmsHelper aliyunSmsHelper;

    @Resource(name = "taskExecutor")
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;
    /**
     * 发送短信验证码
     * @param sendVeriticationCodeReqVO
     * @return
     */
    @Override
    public Response<?> send(SendVeriticationCodeReqVO sendVeriticationCodeReqVO) {
        String phone = sendVeriticationCodeReqVO.getPhone();

        //构建验证码 Redis key
        String redisKey = RedisKeyConstants.buildVeriticationCodeKey(phone);

        //验证验证码是否已发送
        boolean isSent  = redisTemplate.hasKey(redisKey);
        if (isSent){
            //若之前发送的验证码未过期 ，则提示发送频繁
            throw new BizException(ResponseCodeEnum.VERITICATION_CODE_ERROR);
        }

        //生成六位随机验证码
        String verificationCode = RandomUtil.randomNumbers(6);
        log.info("===> 手机号：{}, 已发送验证码:【{}】", phone, verificationCode);
        //调用第三方短信发送服务
        threadPoolTaskExecutor.submit(() -> {
            String sigName = "阿里云短信测试";
            String templateCode = "SMS_154950909";
            String templateParams = "{\"code\":\"" + verificationCode + "\"}";
            aliyunSmsHelper.sendMessage(sigName, templateCode, phone, templateParams);
        });
        //存储验证码到Redis ，并设置过期时间为 3分钟
        redisTemplate.opsForValue().set(redisKey, verificationCode, 3, TimeUnit.MINUTES);

        return Response.success(true);
    }
}
