package com.ccyang.apigateway.enums;

/**
 * @author ccyang
 * @date 2018/7/10 18:17
 */
public enum ResultStatus{

    REQUEST_TOO_MUCH(500100, "请求太频繁");

    private String msg;
    private Integer code;

    ResultStatus(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public Integer getCode() {
        return code;
    }
}