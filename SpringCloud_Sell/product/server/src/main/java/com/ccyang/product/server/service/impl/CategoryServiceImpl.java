package com.ccyang.product.server.service.impl;

import com.ccyang.product.server.dataobject.ProductCategory;
import com.ccyang.product.server.repository.ProductCategoryRepository;
import com.ccyang.product.server.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ccyang
 * @date 2018/6/30 20:54
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
    }
}
