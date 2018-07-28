package com.ccyang.order.server.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author ccyang
 * @date 2018/7/6 10:04
 */
public class JsonUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 转换为 Json字符串
     */
    public static String toJson(Object object){
        try{
            return objectMapper.writeValueAsString(object);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Josn字符串转 对象
     */
    public static <T> T fromJson(String str, Class<T> clazz){
        try{
            return objectMapper.readValue(str, clazz);
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * json 转对象集合
     */
    public static <T> T fromJson(String string, TypeReference<T> typeReference){
        try{
            return objectMapper.readValue(string, typeReference);
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

}
