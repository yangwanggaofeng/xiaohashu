package com.study.xiaohashu.auth.controller;

import com.study.framework.biz.operationlog.aspect.ApiOperationLog;
import com.study.framework.common.response.Response;
import com.study.xiaohashu.auth.model.vo.veriticationcode.SendVeriticationCodeReqVO;
import com.study.xiaohashu.auth.service.VerificationCodeService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName VerificationCodeController
 * @Description TODO
 * @Author zhang
 * @Date 2025/1/23
 * @Version 1.0
 **/
@RestController
@Slf4j
public class VerificationCodeController {

    @Resource
    private VerificationCodeService verificationCodeService;

    @PostMapping("/verification/code/send")
    @ApiOperationLog( description = "发送短信验证码")
    public Response<?> sendVerificationCode(@RequestBody @Validated SendVeriticationCodeReqVO sendVeriticationCodeReqVO){
        return verificationCodeService.send(sendVeriticationCodeReqVO);
    }
}
