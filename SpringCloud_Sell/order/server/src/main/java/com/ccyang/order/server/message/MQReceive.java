package com.ccyang.order.server.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.swing.text.StringContent;

/**
 * 接收方
 * @author ccyang
 * @date 2018/7/4 23:13
 */
@Slf4j
@Component
public class MQReceive {

    // 1. 需要手动在39...50:15672/ 下的RabbitMQ management 界面下创建一个队列 myQueue
    //@RabbitListener(queues = "myQueue")
    // 2. 自动创建队列 , 队列不会随着服务停掉而被删除
    //@RabbitListener(queuesToDeclare = @Queue("myQueue"))
    // 3. 自动创建，queue 和 exchange 绑定
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueue"),
            exchange = @Exchange("myExchange")
    ))
    public void receive(String msg){
        log.info("mqReceive = {}" , msg );
    }

    /**----------- 模拟消息分组 --------------------*/
    /**
     * 数码供应商服务  接收消息
     * 消息发到交换机，交换机根据不同的key 发送到不同的队列
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "computer",
            value = @Queue("computerOrder")
    ))
    public void receiveComputer(String msg){
        log.info(" receiveComputer service = {}" , msg );
    }
    /**
     * 水果供应商服务  接收消息
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("fruitOrder"),
            key = "fruit",
            exchange = @Exchange("myOrder")
    ))
    public void receiveFruit(String msg){
        log.info(" receiveFruit service = {}" , msg );
    }
}
