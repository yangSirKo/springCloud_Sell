package com.ccyang.order.server.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author ccyang
 * @date 2018/7/5 13:12
 */
@Component
public class StreamSender {

//    @Autowired
//    private StreamClient streamClient;
//
//    public void sendProcess(){
//        String message = "now " + new Date();
//        streamClient.output().send(MessageBuilder.withPayload(message).build());
//    }
}
