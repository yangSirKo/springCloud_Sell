package com.ccyang.order.server.enums;

import lombok.Getter;

/**
 * @author ccyang
 * @date 2018/6/30 23:39
 */
@Getter
public enum OrderStatusEnum {

    NEW(0,"新订单"),
    FINISHED(1, "完结"),
    CANCEL(2, "取消"),
    ;

    private Integer code;
    private String msg;

    OrderStatusEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

}
