package com.ccyang.product.client;

import com.ccyang.product.common.DecreaseStockInput;
import com.ccyang.product.common.ProductInfoOutput;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author ccyang
 * @date 2018/7/3 9:52
 */
@FeignClient(name = "product")
@Component
public interface ProductClient {

    /**
     * 查询商品接口
     * @param productIdList
     * @return
     */
    @PostMapping("/product/getProductList")
    public List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList);

    /**
     * 减库存接口
     * @param decreaseStockInputList
     */
    @PostMapping("/product/productDecreaseStock")
    public void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList);

    /**
     * 测试接口是否可以使用
     * @return
     */
    @GetMapping("/getMsg")
    public String getMsg();

}
