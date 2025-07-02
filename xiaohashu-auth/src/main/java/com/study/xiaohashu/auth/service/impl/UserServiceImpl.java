package com.study.xiaohashu.auth.service.impl;

import com.study.framework.common.exception.BizException;
import com.study.framework.common.response.Response;
import com.study.framework.common.util.JsonUtils;
import com.study.xiaohashu.auth.constant.Constants;
import com.study.xiaohashu.auth.constant.RedisKeyConstants;
import com.study.xiaohashu.auth.domain.dataobject.UserDO;
import com.study.xiaohashu.auth.domain.mapper.UserDOMapper;
import com.study.xiaohashu.auth.enums.LoginTypeEnum;
import com.study.xiaohashu.auth.enums.ResponseCodeEnum;
import com.study.xiaohashu.auth.model.vo.user.UserLoginReqVO;
import com.study.xiaohashu.auth.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author zhang
 * @Date 2025/6/24
 * @Version 1.0
 **/
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private UserDOMapper userDOMapper;
    /**
     * 登录与注册
     * @param userLoginReqVO
     * @return
     */
    @Override
    public Response<String> loginAndRegister(UserLoginReqVO userLoginReqVO) {
        String phone = userLoginReqVO.getPhone();
//        Integer loginType = userLoginReqVO.getType();
        Integer loginType = userLoginReqVO.getType();
        LoginTypeEnum loginTypeEnum = LoginTypeEnum.valueOf(loginType);
        Long userId = null;
        //判断登录类型
        switch (loginTypeEnum){
            case VERIFICATION_CODE:
                String verificationCode = userLoginReqVO.getCode();
                //校验验证码是否为空
                if(StringUtils.isBlank(verificationCode)){
                    return Response.fail(ResponseCodeEnum.PARAM_NOT_INVALID.getErrorCode(), "验证码不能为空" );
                }
                //构建验证码Key
                String key = RedisKeyConstants.buildVeriticationCodeKey(phone);
                String sendCode = (String) redisTemplate.opsForValue().get(key);
                if(!StringUtils.equals(verificationCode, sendCode)){
                    throw new BizException(ResponseCodeEnum.VERITICATION_CODE_ERROR);
                }
                //通过手机号查询记录
                UserDO userDO = userDOMapper.selectByPhone(Constants.SCHEMA, phone);
                log.info("===>用户是否注册，phone:{}, userDo:{}", phone, JsonUtils.toJsonString(userDO));
                if(Objects.isNull(userDO)){
                    //todo 注册
                }else{
                    //已注册，获取用户ID
                    userId = userDO.getId();
                }
                break;
            case PASSWORD: //密码登录
                //todo
                break;
            default:
                break;


        }
        //Satoken 登录用户，并返回token令牌
        //todo
        return Response.success("");
    }
}
