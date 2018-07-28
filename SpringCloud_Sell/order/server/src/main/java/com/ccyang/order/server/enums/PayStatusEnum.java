package com.ccyang.order.server.enums;

import lombok.Getter;

/**
 * @author ccyang
 * @date 2018/6/30 23:42
 */
@Getter
public enum PayStatusEnum {

    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),
    ;

    private Integer code;
    private String msg;

    PayStatusEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

}
