package com.ccyang.product.server.repository;

import com.ccyang.product.server.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author ccyang
 * @date 2018/6/30 20:04
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer>{

    /**
     * 获取类目
     * @param categoryTypeList  In 表示传入的参数为 List
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);


}
