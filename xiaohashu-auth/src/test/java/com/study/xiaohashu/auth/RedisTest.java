package com.study.xiaohashu.auth;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @ClassName RedisTest
 * @Description TODO
 * @Author zhang
 * @Date 2025/1/14
 * @Version 1.0
 **/
@SpringBootTest
@Slf4j
public class RedisTest {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * set key value
     */
    @Test
    void testSetKeyValue() {
        // 添加一个 key 为 name
        redisTemplate.opsForValue().set("name6", "redistest");
    }
    /**
     * 判断某个 key是否存在
     */
    @Test
    void testGetKey(){
        log.info("value 值：{}", redisTemplate.opsForValue().get("k1"));
    }
}
