package com.ccyang.product.server.repository;

import com.ccyang.product.server.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author ccyang
 * @date 2018/6/30 18:15
 */
// 第二个参数为主键类型
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    // 查询所有在架商品
    List<ProductInfo> findByProductStatus(Integer productStatus);

    // 根据商品ID 查询商品信息
    List<ProductInfo> findByProductIdIn(List<String> productIdList);
}
