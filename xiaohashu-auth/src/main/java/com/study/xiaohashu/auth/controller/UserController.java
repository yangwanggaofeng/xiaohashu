package com.study.xiaohashu.auth.controller;

import com.study.framework.biz.operationlog.aspect.ApiOperationLog;
import com.study.framework.common.response.Response;
import com.study.xiaohashu.auth.model.vo.user.UserLoginReqVO;
import com.study.xiaohashu.auth.service.UserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author zhang
 * @Date 2025/7/1
 * @Version 1.0
 **/
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/login")
    @ApiOperationLog(description = "用户登录/注册")
    public Response<String> loginAndRegister(@RequestBody UserLoginReqVO userLoginReqVO){
        return userService.loginAndRegister(userLoginReqVO);
    }
}
