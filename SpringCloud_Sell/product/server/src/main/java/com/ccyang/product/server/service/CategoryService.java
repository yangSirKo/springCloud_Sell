package com.ccyang.product.server.service;

import com.ccyang.product.server.dataobject.ProductCategory;

import java.util.List;

/**
 * 类目
 * @author ccyang
 * @date 2018/6/30 20:51
 */
public interface CategoryService {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);


}
