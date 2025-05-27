package com.study.framework.common.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.study.framework.common.constant.DateConstants;
import lombok.SneakyThrows;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @ClassName JsonUtils
 * @Description TODO
 * @Author zhang
 * @Date 2024/12/17
 * @Version 1.0
 **/
public class JsonUtils {
//    private static final  ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static   ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
//        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        OBJECT_MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
////        JavaTimeModule javaTimeModule = new JavaTimeModule();
////        //支持LocatDateTime
////        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DateConstants.Y_M_D_H_M_S_FORMAT)));
////        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(DateConstants.Y_M_D_H_M_S_FORMAT)));
//        OBJECT_MAPPER.registerModule(new JavaTimeModule()); //解决LocalDateTime的序列化问题

    }

    /**
     * 初始化：统一使用 Spring Boot 个性化配置的 ObjectMapper
     * @param objectMapper
     */
    public static void init(ObjectMapper objectMapper){
        OBJECT_MAPPER = objectMapper;
    }
    /**
     * 将对象转化为JSON字符串
     */
    @SneakyThrows
    public static String toJsonString(Object obj){
        return OBJECT_MAPPER.writeValueAsString(obj);
    }
}
