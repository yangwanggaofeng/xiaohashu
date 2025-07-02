package com.study.xiaohashu.auth;

import com.study.xiaohashu.auth.domain.dataobject.UserDO;
import com.study.xiaohashu.auth.domain.mapper.UserDOMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
@Slf4j
class XiaohashuAuthApplicationTests {

    @Resource
    private UserDOMapper userDOMapper;
    @Test
    void testInsert() {
        UserDO userDO = UserDO.builder().nickname("小哈书")
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();
        userDOMapper.insert(userDO);
    }
    @Test
    void testSelect() {
        UserDO userDO = userDOMapper.selectByPrimaryKey(1L);
        log.info("userDO:{}", userDO);
    }

}
