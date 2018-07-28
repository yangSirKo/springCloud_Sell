package com.ccyang.product.server.service.impl;

import com.ccyang.product.common.DecreaseStockInput;
import com.ccyang.product.common.ProductInfoOutput;
import com.ccyang.product.server.ProductApplicationTests;
import com.ccyang.product.server.dataobject.ProductInfo;
import com.ccyang.product.server.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author ccyang
 * @date 2018/6/30 20:43
 */
@Component
public class ProductServiceImplTest extends ProductApplicationTests {

    @Autowired
    private ProductService productService;

    @Test
    public void findUpAll() {
        List<ProductInfo> list = productService.findUpAll();
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void findList() {
        List<ProductInfoOutput> list = productService.findList(Arrays.asList("164103465734242707"));
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void decreaseStock() {
        DecreaseStockInput decreaseStockInput = new DecreaseStockInput();
        decreaseStockInput.setProductId("157875196366160022");
        decreaseStockInput.setProductQuantity(2);
        productService.decreaseStock(Arrays.asList(decreaseStockInput));
    }
}