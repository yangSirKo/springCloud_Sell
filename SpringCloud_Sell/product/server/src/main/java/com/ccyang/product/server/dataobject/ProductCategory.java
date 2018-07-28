package com.ccyang.product.server.dataobject;

import lombok.Data;
import lombok.Generated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author ccyang
 * @date 2018/6/30 17:31
 */
@Data
@Entity
public class ProductCategory {

    @Id
    @GeneratedValue   // 自增
    private Integer categoryId;
    /** 类目名字 */
    private String categoryName;
    /** 类目编号 */
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

  }
