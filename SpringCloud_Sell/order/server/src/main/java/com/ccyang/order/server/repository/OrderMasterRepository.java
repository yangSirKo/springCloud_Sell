package com.ccyang.order.server.repository;

import com.ccyang.order.server.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * OrderMasterRepository 会继承 JpaRepository 的方法
 * @author ccyang
 * @date 2018/6/30 23:29
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

}
