package com.study.xiaohashu.auth.service;

import com.study.framework.common.response.Response;
import com.study.xiaohashu.auth.model.vo.user.UserLoginReqVO;

public interface UserService {
    /**
     * 登录与注册
     * @param userLoginReqVO
     * @return
     */
    Response<String> loginAndRegister(UserLoginReqVO userLoginReqVO);
}
