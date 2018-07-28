package com.ccyang.product.server.service;

import com.ccyang.product.common.DecreaseStockInput;
import com.ccyang.product.common.ProductInfoOutput;
import com.ccyang.product.server.dataobject.ProductInfo;

import java.util.List;

/**
 * @author ccyang
 * @date 2018/6/30 20:28
 */
public interface ProductService {

    /**
     * 查询在架商品
     */
    List<ProductInfo> findUpAll();

    /**
     * 根据 ProductId 查询商品
     */
    List<ProductInfoOutput> findList(List<String> productIdList);

    /**
     * 扣库存
     */
    void decreaseStock(List<DecreaseStockInput> decreaseStockInputList);
}
