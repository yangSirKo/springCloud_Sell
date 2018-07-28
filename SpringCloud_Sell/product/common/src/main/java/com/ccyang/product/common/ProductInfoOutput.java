package com.ccyang.product.common;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 给其他服务返回商品信息的封装类
 * @author ccyang
 * @date 2018/7/3 9:41
 */
@Data
public class ProductInfoOutput {

    private String productId;
    /** 名字 */
    private String productName;
    /** 价格 */
    private BigDecimal productPrice;
    /** 库存 */
    private Integer productStock;
    /** 描述 */
    private String productDescription;
    /** 小图 */
    private String productIcon;
    /** 状态，0 正常、1 下架 */
    private Integer productStatus;
    /** 类目编号 */
    private Integer categoryType;

    private Date createTime;
    private Date updateTime;
}
