package com.study.framework.common.response;

import com.study.framework.common.exception.BaseExceptionInterface;
import com.study.framework.common.exception.BizException;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName Response
 * @Description 响应参数工具类
 * @Author zhang
 * @Date 2024/12/13
 * @Version 1.0
 **/
@Data
public class Response <T> implements Serializable {
    // 是否成功，默认为 true
    private boolean success = true;
    // 响应消息
    private String message;
    // 异常码
    private String errorCode;
    // 响应数据
    private T data;
    // =================================== 成功响应 ===================================
    public static <T> Response<T> success() {
        Response<T> response = new Response<>();
        return response;
    }

    public static <T> Response<T> success(T data) {
        Response<T> response = new Response<>();
        response.setData(data);
        return response;
    }

    // =================================== 失败响应 ===================================
    public static <T> Response<T> fail() {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        return response;
    }

    public static <T> Response<T> fail(String errorMessage) {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        response.setMessage(errorMessage);
        return response;
    }

    public static <T> Response<T> fail(String errorCode, String errorMessage) {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        response.setErrorCode(errorCode);
        response.setMessage(errorMessage);
        return response;
    }
    public static <T> Response<T> fail(BizException e) {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        response.setErrorCode(e.getErrorCode());
        response.setMessage(e.getErrorMessage());
        return response;
    }
    public static <T> Response<T> fail(BaseExceptionInterface e) {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        response.setErrorCode(e.getErrorCode());
        response.setMessage(e.getErrorMessage());
        return response;
    }

}
