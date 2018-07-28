package com.ccyang.product.server.enums;

import lombok.Getter;

/**
 * @author ccyang
 * @date 2018/7/2 13:15
 */
@Getter
public enum ResultEnum {

    PRODUCT_NOT_EXIST(500201, "商品不存在"),
    PRODUCT_STOCK_ERROR(500202, "商品库存不足")
    ;

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
