package com.ccyang.product.server.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author ccyang
 * @date 2018/6/30 21:04
 */
@Data
public class ProductVO {

    @JsonProperty("name")   // 展示给前台时，categoryName 会自动转换为 name
    private String categoryName;   // categoryName 使我们明确这个参数的意思

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    List<ProductInfoVO> productInfoVOList;

}
