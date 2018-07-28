package com.ccyang.product.server.enums;

import lombok.Getter;

/**
 * 商品上下架状态
 * @author ccyang
 * @date 2018/6/30 20:33
 */
@Getter
public enum ProductStatusEnum {

    UP(0, "在架商品"),
    DOWN(1, "下架商品"),
    ;

    private Integer code;
    private String message;

    ProductStatusEnum(Integer code , String message){
        this.code = code;
        this.message = message;
    }

}
