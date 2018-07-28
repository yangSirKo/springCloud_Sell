package com.ccyang.product.server.exception;

import com.ccyang.product.server.enums.ResultEnum;

/**
 * @author ccyang
 * @date 2018/7/2 13:14
 */
public class ProductException extends RuntimeException {

    private Integer code;

    public ProductException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

}
