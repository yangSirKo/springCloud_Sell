package com.ccyang.product.server.repository;

import com.ccyang.product.server.ProductApplicationTests;
import com.ccyang.product.server.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author ccyang
 * @date 2018/6/30 18:20
 */
@Component
public class ProductInfoRepositoryTest extends ProductApplicationTests{
    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void findByProductStatus() {
        List<ProductInfo> list =  productInfoRepository.findByProductStatus(0);
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void findByProductIdIn(){
        List<ProductInfo> list = productInfoRepository.findByProductIdIn(Arrays.asList("164103465734242707"));
        Assert.assertTrue(list.size() > 0);
    }

}