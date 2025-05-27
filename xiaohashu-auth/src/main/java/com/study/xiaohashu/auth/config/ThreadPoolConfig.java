package com.study.xiaohashu.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName ThreadPoolConfig
 * @Description 自定义线程池配置
 * @Author zhang
 * @Date 2025/1/26
 * @Version 1.0
 **/
@Configuration
public class ThreadPoolConfig {

    @Bean("taskExecutor")
    public Executor taskExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //核心线程数
        executor.setCorePoolSize(10);
        //最大线程数
        executor.setMaxPoolSize(50);
        //队列容量
        executor.setQueueCapacity(200);
        //线程活跃时间
        executor.setKeepAliveSeconds(30);
        //线程名称前缀
        executor.setThreadNamePrefix("AuthExecutor-");
        //拒绝策略，由调用线程处理，一般为主线程
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        //等待所有任务结束后再关闭主线程
        executor.setWaitForTasksToCompleteOnShutdown(true);
        //设置等待时间，如果超过此时间还没有销毁，则强制销毁，以确保应用最后能够被关闭，而不是被没有完成的任务阻塞
        executor.setAwaitTerminationSeconds(60);
        executor.initialize();
        return executor;
    }
}
