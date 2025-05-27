package com.study.xiaohashu.auth.constant;

/**
 *
 */
public class RedisKeyConstants {
    /**
     * 验证码 KEY 前缀
     */
    private static final String VERITICATION_CODE_KEY_PRIFIX = "veritication_code:";
    /**
     * 构建验证码Key
     */
    public static String buildVeriticationCodeKey(String phone){
        return VERITICATION_CODE_KEY_PRIFIX + phone;
    }
}
