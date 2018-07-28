package com.ccyang.order.server.repository;

import com.ccyang.order.server.OrderApplicationTests;
import com.ccyang.order.server.dataobject.OrderMaster;
import com.ccyang.order.server.enums.OrderStatusEnum;
import com.ccyang.order.server.enums.PayStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author ccyang
 * @date 2018/6/30 23:33
 */
@Component
public class OrderMasterRepositoryTest extends OrderApplicationTests{

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void testSave(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234569");
        orderMaster.setBuyerName("ccyang");
        orderMaster.setBuyerAddress("延大701");
        orderMaster.setBuyerPhone("17868812266");
        orderMaster.setBuyerOpenid("110110110");
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
//        orderMaster.setCreateTime(new Date());
//        orderMaster.setUpdateTime(new Date());
        OrderMaster result = orderMasterRepository.save(orderMaster);
        Assert.assertTrue(result != null );
    }

}