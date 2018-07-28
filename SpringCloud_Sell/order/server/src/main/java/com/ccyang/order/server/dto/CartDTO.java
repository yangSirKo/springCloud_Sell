package com.ccyang.order.server.dto;

import lombok.Data;

/**
 * @author ccyang
 * @date 2018/7/2 13:09
 */
@Data
public class CartDTO {

    /** 商品ID */
    private String productId;

    /** 商品数量 */
    private Integer productQuanlity;

    public CartDTO() {
    }

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuanlity = productQuantity;
    }
}
