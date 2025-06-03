package com.study.framework.common.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName BizException
 * @Description TODO
 * @Author zhang
 * @Date 2024/12/13
 * @Version 1.0
 **/
@Setter
@Getter
public class BizException extends RuntimeException{
    // 异常码
    private String errorCode;
    // 错误信息
    private String errorMessage;

    public BizException(BaseExceptionInterface baseExceptionInterface){
        this.errorCode = baseExceptionInterface.getErrorCode();
        this.errorMessage = baseExceptionInterface.getErrorMessage();
    }
}
