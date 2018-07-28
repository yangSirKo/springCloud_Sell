package com.ccyang.order.server.dataobject;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ccyang
 * @date 2018/6/30 22:50
 */
@Data
@Entity
public class OrderMaster {

    /** 订单id */
    @Id
    private String orderId;
    /** 买家姓名 */
    private String buyerName;
    /** 买家手机号 */
    private String buyerPhone;
    /** 买家地址 */
    private String buyerAddress;
    /** 买家微信 Openid , 买家的唯一标识*/
    private String buyerOpenid;
    /** 订单总金额 */
    private BigDecimal orderAmount;
    /** 订单状态，默认为 0 表示新下单 */
    private Integer orderStatus;
    /** 支付状态，默认为 0 表示未支付 */
    private Integer payStatus;
    /** 创建时间 */
//    private Date createTime;
//    /** 更新时间 */
//    private Date updateTime;

}
