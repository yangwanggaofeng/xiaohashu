package com.study.xiaohashu.auth.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 状态
 */
@AllArgsConstructor
@Getter
public enum StatusEnum {
    ENABLE(0),
    DISABLED(1);
    private final Integer value;
}

