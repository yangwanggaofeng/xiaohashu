package com.study.xiaohashu.auth;

import com.alibaba.druid.filter.config.ConfigTools;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName DriudTests
 * @Description DriudTests 测试类
 * @Author zhang
 * @Date 2024/12/23
 * @Version 1.0
 **/
@SpringBootTest
@Slf4j
public class DriudTests {

    /**
     * Driud 密码加密
     */
    @Test
    @SneakyThrows
    void test(){
        String password = "123456";
        String[] array = ConfigTools.genKeyPair(512);
        //私钥
        log.info("private key :{}", array[0]);

        //公钥
        log.info("public key : {}", array[1]);

        //通过私钥加密密码
        String encrypt = ConfigTools.encrypt(array[0], password);
        log.info("加密后 password: {}" , encrypt);
    }
}
