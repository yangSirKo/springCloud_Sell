package com.ccyang.user.server.enums;

import lombok.Getter;

/**
 * @author ccyang
 * @date 2018/7/10 20:09
 */
@Getter
public enum RoleEnum {

    BUYER(1, "买家"),
    SELLER(2, "，卖家"),
    ;

    private Integer code;
    private String msg;

    RoleEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
