package com.study.xiaohashu.auth.domain.dataobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @ClassName UserDO
 * @Description TODO
 * @Author zhang
 * @Date 2024/12/18
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDO {
    private Long id;
    private String username;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
