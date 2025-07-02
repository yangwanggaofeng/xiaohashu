package com.study.xiaohashu.auth.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 逻辑删除枚举类
 */
@AllArgsConstructor
@Getter
public enum DeletedEnum {
    YES(true),
    No(false);
    private Boolean value;


}
