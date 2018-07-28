package com.ccyang.order.server.service;

import com.ccyang.order.server.dto.OrderDTO;

/**
 * @author ccyang
 * @date 2018/7/1 9:50
 */
public interface OrderService {

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);

    /**
     * 完结订单 ( 只能卖家操作 )
     * @param orderId
     * @return
     */
    OrderDTO finish(String orderId);

}
