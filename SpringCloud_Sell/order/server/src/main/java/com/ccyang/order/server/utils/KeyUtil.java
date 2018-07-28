package com.ccyang.order.server.utils;

import java.util.Random;
import java.util.UUID;

/**
 * @author ccyang
 * @date 2018/7/1 10:06
 */
public class KeyUtil {

    /**
     *  使用 UUID 生成唯一的订单号
     */
    public static synchronized String genUniqueKey(){
        return UUID.randomUUID().toString().replace("-","");
    }



    public static void main(String[] args) {
        for(int i=0; i<5; i++ ){
            System.out.println(genUniqueKey());
        }
    }


}
