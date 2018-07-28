package com.ccyang.order.server.dto;

import com.ccyang.order.server.dataobject.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * dto : data transfer object
 * @author ccyang
 * @date 2018/7/1 9:53
 */
@Data
public class OrderDTO {

    /** 订单id */
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

    private List<OrderDetail> orderDetailList;

}
