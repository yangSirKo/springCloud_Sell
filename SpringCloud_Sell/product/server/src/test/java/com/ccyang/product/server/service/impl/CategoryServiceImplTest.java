package com.ccyang.product.server.service.impl;

import com.ccyang.product.server.ProductApplicationTests;
import com.ccyang.product.server.dataobject.ProductCategory;
import com.ccyang.product.server.service.CategoryService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author ccyang
 * @date 2018/6/30 20:55
 */
@Component
public class CategoryServiceImplTest extends ProductApplicationTests {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> list = categoryService.findByCategoryTypeIn(Arrays.asList(11,22));
        Assert.assertTrue(list.size() > 0);
    }
}