package com.study.framework.common.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @ClassName PhoneNumberValidator
 * @Description TODO
 * @Author zhang
 * @Date 2025/2/7
 * @Version 1.0
 **/
public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {
    @Override
    public void initialize(PhoneNumber constraintAnnotation) {
        //这里进行一些初始化
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
        //校验逻辑: 正则表达式判断手机号是否为11位
        return phoneNumber != null && phoneNumber.matches("\\d{11}");
    }
}
