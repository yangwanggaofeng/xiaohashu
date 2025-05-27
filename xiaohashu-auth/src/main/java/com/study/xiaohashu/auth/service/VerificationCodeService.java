package com.study.xiaohashu.auth.service;

import com.study.framework.common.response.Response;
import com.study.xiaohashu.auth.model.vo.veriticationcode.SendVeriticationCodeReqVO;

public interface VerificationCodeService {
    /**
     * 发送短信验证码
     */
    Response<?> send(SendVeriticationCodeReqVO sendVeriticationCodeReqVO);
}
