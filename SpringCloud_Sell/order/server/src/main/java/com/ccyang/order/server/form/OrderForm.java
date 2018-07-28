package com.ccyang.order.server.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author ccyang
 * @date 2018/7/1 10:26
 */
@Data
public class OrderForm {

    /** 买家姓名 */
    @NotEmpty(message = "姓名必填")
    private String name;
    /** 买家手机号 */
    @NotEmpty(message = "手机号必填")
    private String phone;
    /** 买家地址 */
    @NotEmpty(message = "地址必填")
    private String address;
    /** 买家微信 openid */
    @NotEmpty(message = "openid 必填")
    private String openid;
    /** 购物车：前台传入的json会转为字符串 */
    @NotEmpty(message = "购物车不能为空")
    private String items;
}
