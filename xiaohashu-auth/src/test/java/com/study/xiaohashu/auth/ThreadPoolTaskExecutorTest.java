package com.study.xiaohashu.auth;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @ClassName ThreadPoolTaskExecutorTest
 * @Description TODO
 * @Author zhang
 * @Date 2025/1/26
 * @Version 1.0
 **/
@SpringBootTest
@Slf4j
public class ThreadPoolTaskExecutorTest {
    @Resource
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Test
    public void test(){
        threadPoolTaskExecutor.submit(() ->{
            log.info("springboot 自定义线程池测试");
        });
    }
}
