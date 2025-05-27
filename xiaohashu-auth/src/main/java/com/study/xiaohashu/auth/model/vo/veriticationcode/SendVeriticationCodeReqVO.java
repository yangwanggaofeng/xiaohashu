package com.study.xiaohashu.auth.model.vo.veriticationcode;

import com.study.framework.common.validator.PhoneNumber;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName SendVeriticationCodeReqVO
 * @Description 发送验证码请求参数
 * @Author zhang
 * @Date 2025/1/20
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SendVeriticationCodeReqVO {
    @NotBlank(message = "手机号不能为空")
    @PhoneNumber
    private String phone;
}
