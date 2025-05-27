package com.study.xiaohashu.auth.sms;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.teautil.models.RuntimeOptions;
import com.study.framework.common.util.JsonUtils;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @ClassName AliyunSmsHelper
 * @Description TODO
 * @Author zhang
 * @Date 2025/2/5
 * @Version 1.0
 **/
@Component
@Slf4j
public class AliyunSmsHelper {

    @Resource
    private Client client;

    /**
     *
     */
    public boolean sendMessage(String signName, String templateCode, String phone, String templateParams){
        SendSmsRequest sendSmsRequest = new SendSmsRequest()
                .setSignName(signName)
                .setTemplateCode(templateCode)
                .setPhoneNumbers(phone)
                .setTemplateParam(templateParams);
        RuntimeOptions runtimeOptions = new RuntimeOptions();

        try {
            log.info("===>开始短信发送,phone:{}, sigName: {}, templateCode: {}, templateParams: {}", phone, signName, templateCode, templateParams);
            // 发送短信
            SendSmsResponse response = client.sendSmsWithOptions(sendSmsRequest, runtimeOptions);
            log.info("==> 短信发送成功, response: {}", JsonUtils.toJsonString(response));
            return true;
        } catch (Exception error) {
            error.printStackTrace();
            log.error("==> 短信发送错误: ", error);
            return false;
        }
    }
}
