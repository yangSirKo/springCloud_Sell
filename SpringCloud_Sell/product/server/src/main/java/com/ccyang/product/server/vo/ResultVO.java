package com.ccyang.product.server.vo;

import lombok.Data;

/**
 * VO ： view object,  http请求返回的最外层对象
 * @author ccyang
 * @date 2018/6/30 21:00
 */
@Data
public class ResultVO<T> {

    /**
     * 状态码，正常返回值为0
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 具体内容
     */
    private T data;

}
