package com.study.framework.biz.operationlog.aspect;

import java.lang.annotation.*;

/**
 * @ClassName ApiOperationLog
 * @Description TODO
 * @Author zhang
 * @Date 2024/12/17
 * @Version 1.0
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface ApiOperationLog {
    /**
     * API 功能描述
     */
    String description() default "";
}
