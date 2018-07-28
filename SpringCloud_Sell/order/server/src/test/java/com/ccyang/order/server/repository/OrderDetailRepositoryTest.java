package com.ccyang.order.server.repository;

import com.ccyang.order.server.OrderApplicationTests;
import com.ccyang.order.server.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author ccyang
 * @date 2018/7/1 9:25
 */
@Component
public class OrderDetailRepositoryTest extends OrderApplicationTests{

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void testSave(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("12345");
        orderDetail.setOrderId("1234567");
        orderDetail.setProductId("157875196366160022");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductPrice(new BigDecimal(3.0));
        orderDetail.setProductQuantity(2);

        OrderDetail result =  orderDetailRepository.save(orderDetail);
        Assert.assertTrue( result != null );
    }

}