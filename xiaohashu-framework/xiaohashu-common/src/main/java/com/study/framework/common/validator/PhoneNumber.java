package com.study.framework.common.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * @ClassName PhoneNumber
 * @Description 自定义手机号校验注解
 * @Author zhang
 * @Date 2025/2/7
 * @Version 1.0
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER})
@Constraint(validatedBy = PhoneNumberValidator.class)
@Documented
public @interface PhoneNumber {
    String message() default "手机号格式不正确，需要11位数字";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
