package com.study.xiaohashu.auth.enums;

import com.study.framework.common.exception.BaseExceptionInterface;
import com.study.framework.common.exception.BizException;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ClassName ResponseCodeEnum
 * @Description TODO
 * @Author zhang
 * @Date 2025/1/3
 * @Version 1.0
 **/
@AllArgsConstructor
@Getter
public enum ResponseCodeEnum implements BaseExceptionInterface {

    //--------------通用异常状态码--------------
    SYSTEM_ERROR("AUTH-10000","出错了，后台小哥正在努力修复..."),
    PARAM_NOT_INVALID("AUTH-10001","参数错误"),

    //--------------业务异常状态码--------------
//    VERITICATION_CODE_ERROR("AUTH-20000","请求太频繁，请三分钟后再试"),
    VERITICATION_CODE_ERROR("AUTH-20001","验证码错误"),

    ;

    //异常码
    private final String errorCode;
    //错误信息
    private final String errorMessage;
}
