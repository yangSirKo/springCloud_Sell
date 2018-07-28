package com.ccyang.product.server.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ccyang
 * @date 2018/6/30 17:31
 */
//@Table(name="product_info")
@Data  // 自动生成 getter 和 setter
@Entity  // 映射到数据库实体
public class ProductInfo {

    @Id
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
