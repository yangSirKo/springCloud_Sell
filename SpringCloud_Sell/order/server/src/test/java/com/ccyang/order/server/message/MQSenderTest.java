package com.ccyang.order.server.message;

import com.ccyang.order.server.OrderApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.junit.Assert.*;

/**
 * @author ccyang
 * @date 2018/7/4 23:26
 */
@Component
public class MQSenderTest extends OrderApplicationTests{

    @Autowired
    private MQSender sender;

    @Test
    public void sendTest() {
        sender.send();
    }

    @Test
    public void sendOrderTest() {
        sender.sendOrder();
    }

}