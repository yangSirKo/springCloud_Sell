package com.ccyang.product.common;

import lombok.Data;

/**
 * 减库存入参
 * @author ccyang
 * @date 2018/7/3 9:43
 */
@Data
public class DecreaseStockInput {
    /** 商品id */
    private String productId;

    /** 商品数量 */
    private Integer productQuantity;

    public DecreaseStockInput() {
    }

    public DecreaseStockInput(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

}
