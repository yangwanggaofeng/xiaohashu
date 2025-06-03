package com.study.xiaohashu.auth.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.framework.biz.operationlog.aspect.ApiOperationLog;
import com.study.framework.common.response.Response;
import com.study.framework.common.util.JsonUtils;
import com.study.xiaohashu.auth.domain.dataobject.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author zhang
 * @Date 2024/12/13
 * @Version 1.0
 **/
@RestController
public class TestController {
    @GetMapping("/test")
    @ApiOperationLog(description = "测试接口")
    public Response<String> test(){
//        TestController testController = new TestController();
//        testController.getClass().getSimpleName();
        System.out.println("test=========");
        return Response.success("Hello, 犬小哈专栏");
    }
    @GetMapping("/test2")
    @ApiOperationLog(description = "Java 8 新日期 API 字段")
    public Response<User> test2(){
        return Response.success(User.builder().nickname("Java 8 新日期 转json测试").createTime(LocalDateTime.now()).build());
    }

    @PostMapping("/testJava8Date")
    @ApiOperationLog(description = "自定义 Jackson 配置：支持 LocalDateTime 日期 API")
    public Response<User> test3(@RequestBody @Validated User user) throws JsonProcessingException {

       int i = 1/0;
       return Response.success(user);
    }
    // 测试登录，浏览器访问： http://localhost:8080/user/doLogin?username=zhang&password=123456
    @RequestMapping("/user/doLogin")
    @ApiOperationLog(description = "整合 SaToken 权限认证框架，以及初步尝鲜")
    public String doLogin(@RequestParam("username") String username, @RequestParam("password") String password){
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        if("zhang".equals(username) && "123456".equals(password)){
            StpUtil.login(10001);
            return "登录成功";
        }
        return "登录失败";
    }

    //查询登录状态，浏览器访问http://localhost:8080/user/isLogin
    @RequestMapping("/user/isLogin")
    public String isLogin(){
        return "当前会话是否登录" + StpUtil.isLogin();
    }


}
