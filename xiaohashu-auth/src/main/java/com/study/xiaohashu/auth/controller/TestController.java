package com.study.xiaohashu.auth.controller;

import com.study.framework.biz.operationlog.aspect.ApiOperationLog;
import com.study.framework.common.response.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
