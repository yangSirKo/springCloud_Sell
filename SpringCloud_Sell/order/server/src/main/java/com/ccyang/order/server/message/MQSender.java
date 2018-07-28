package com.ccyang.order.server.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 发送方
 * @author ccyang
 * @date 2018/7/4 23:19
 */
@Component
@Slf4j
public class MQSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String msg = "mqsender send ..." + new Date();
        amqpTemplate.convertAndSend("myQueue", msg);
    }

    /**
     * 模拟消息分组 发送方
     */
    public void sendOrder(){
        String msg = "mqsender send ..." + new Date();
        amqpTemplate.convertAndSend("myOrder","computer", msg);
    }

}
