package com.ccyang.order.server.repository;

import com.ccyang.order.server.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * OrderDetailRepository 会继承 JpaRepository 的方法
 * @author ccyang
 * @date 2018/6/30 23:31
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String>{

    List<OrderDetail> findByOrderId(String orderId);

}
