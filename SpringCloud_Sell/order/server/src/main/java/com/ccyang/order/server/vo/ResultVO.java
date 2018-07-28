package com.ccyang.order.server.vo;

import lombok.Data;

/**
 * @author ccyang
 * @date 2018/7/1 11:27
 */
@Data
public class ResultVO<T> {

    /**
     * 状态码
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String massage;
    /**
     * 具体数据
     */
    private T data;

}
