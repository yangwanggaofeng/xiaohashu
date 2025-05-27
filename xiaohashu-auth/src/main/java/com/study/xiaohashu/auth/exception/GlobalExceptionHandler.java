package com.study.xiaohashu.auth.exception;

import com.study.framework.common.exception.BizException;
import com.study.framework.common.response.Response;
import com.study.xiaohashu.auth.enums.ResponseCodeEnum;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

/**
 * @ClassName GlobalExceptionHandler
 * @Description TODO
 * @Author zhang
 * @Date 2025/1/3
 * @Version 1.0
 **/
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 捕获自定义业务异常
     * @return
     */
    @ExceptionHandler({ BizException.class })
    @ResponseBody
    public Response<Object> handleBizException(HttpServletRequest request, BizException e){
        log.warn("{}, return faile, errorCode:{}, errorMessage:{}", request.getRequestURI(), e.getErrorCode(), e.getErrorMessage());
        return Response.fail(e);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    public Response<Object> handleMethodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException e) {
        //参数错误异常码
        String errorCode = ResponseCodeEnum.PARAM_NOT_INVALID.getErrorCode();
        //获取 BindResult
        BindingResult bindResult = e.getBindingResult();

        StringBuilder sb = new StringBuilder();
        // 获取校验不通过的字段，并组合错误信息，格式为： email 邮箱格式不正确, 当前值: '123124qq.com';
        Optional.ofNullable(bindResult.getFieldErrors()).ifPresent(errors -> {
            errors.forEach(error ->{
                sb.append(error.getField())
                        .append("")
                        .append(error.getDefaultMessage())
                        .append(",当前值:'")
                        .append(error.getRejectedValue())
                        .append("';");
            });
        });
        // 错误信息
        String errorMessage = sb.toString();

        log.warn("{}, return faile, errorCode:{}, errorMessage:{}", request.getRequestURI(), errorCode, errorMessage);
        return Response.fail(errorCode, errorMessage);
    }

    /**
     * 其他类型异常
     *
     */
    @ExceptionHandler({Exception.class})
    @ResponseBody
    public Response<Object> handleException(HttpServletRequest request, Exception e) {
        log.error("{}, request error", request.getRequestURI(), e);
        return Response.fail(ResponseCodeEnum.SYSTEM_ERROR);
    }

}
