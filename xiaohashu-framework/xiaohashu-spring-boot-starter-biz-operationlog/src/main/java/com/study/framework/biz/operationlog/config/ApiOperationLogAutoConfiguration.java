package com.study.framework.biz.operationlog.config;

import com.study.framework.biz.operationlog.aspect.ApiOperationLogAspect;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName ApiOperationLogAutoConfiguration
 * @Description TODO
 * @Author zhang
 * @Date 2024/12/18
 * @Version 1.0
 **/
@AutoConfiguration
public class ApiOperationLogAutoConfiguration {
    @Bean
    public ApiOperationLogAspect apiOperationLogAspect() {
        return new ApiOperationLogAspect();
    }
}
