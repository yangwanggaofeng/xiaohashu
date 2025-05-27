package com.study.xiaohashu.auth.sms;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.teaopenapi.models.Config;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName ALiYunSmsClientConfig
 * @Description TODO
 * @Author zhang
 * @Date 2025/2/5
 * @Version 1.0
 **/
@Configuration
@Slf4j
public class AliyunSmsClientConfig {

    @Resource
    private AliyunAccessKeyProperties aliyunAccessKeyProperties;

    @Bean
    public Client smsClient(){
        // 工程代码泄露可能会导致 AccessKey 泄露，并威胁账号下所有资源的安全性。以下代码示例仅供参考。
        // 建议使用更安全的 STS 方式，更多鉴权访问方式请参见：https://help.aliyun.com/document_detail/378657.html。
       try{
           Config config = new Config()
                   // 必填，请确保代码运行环境设置了环境变量 ALIBABA_CLOUD_ACCESS_KEY_ID。
                   .setAccessKeyId(aliyunAccessKeyProperties.getAccessKeyId())
                   // 必填，请确保代码运行环境设置了环境变量 ALIBABA_CLOUD_ACCESS_KEY_SECRET。
                   .setAccessKeySecret(aliyunAccessKeyProperties.getAccessKeySecret());
           // Endpoint 请参考 https://api.aliyun.com/product/Dysmsapi
           config.endpoint = "dysmsapi.aliyuncs.com";
           return new Client(config);
       }catch (Exception e) {
           log.error("初始化阿里云短信发送客户端错误: ", e);
           return null;
       }
    }
}
