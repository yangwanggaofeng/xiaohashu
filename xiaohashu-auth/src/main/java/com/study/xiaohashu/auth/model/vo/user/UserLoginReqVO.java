package com.study.xiaohashu.auth.model.vo.user;

import com.study.framework.common.validator.PhoneNumber;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName UserLoginReqVO
 * @Description 用户登录（支持密码和验证码登录）
 * @Author zhang
 * @Date 2025/6/20
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLoginReqVO {
    @NotBlank(message = "手机号不能为空")
    @PhoneNumber
    private String phone;

    private String code;

    private String password;

    /**
     * 登录类型  手机号验证码登录，或者是帐号密码登录
     */
    @NotNull(message = "登录类型不能为空")
    private Integer type;
}
