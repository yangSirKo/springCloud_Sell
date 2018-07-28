package com.ccyang.user.server.enums;

import lombok.Getter;

/**
 * @author ccyang
 * @date 2018/7/10 20:04
 */
@Getter
public enum ResultEnum {

    LOGIN_FAIL(500200, "登录失败"),
    ROLE_ERROR(500201, "角色不匹配"),
    ;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }

}
