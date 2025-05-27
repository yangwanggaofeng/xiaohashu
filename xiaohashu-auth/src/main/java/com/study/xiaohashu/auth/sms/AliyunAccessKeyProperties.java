package com.study.xiaohashu.auth.sms;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @ClassName ALiYunAccessKeyProperties
 * @Description TODO
 * @Author zhang
 * @Date 2025/2/5
 * @Version 1.0
 **/
@ConfigurationProperties(prefix = "aliyun")
@Component
@Data
public class AliyunAccessKeyProperties {

    private String accessKeyId;
    private String accessKeySecret;
}
