package com.ccyang.order.server.exception;

import com.ccyang.order.server.enums.ResultEnum;

/**
 * 订单异常
 * @author ccyang
 * @date 2018/7/1 10:59
 */
public class OrderException extends RuntimeException {

    private Integer code;

    public OrderException(Integer code, String msg){
        super(msg);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
}
