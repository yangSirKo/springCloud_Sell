package com.ccyang.order.server.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * @author ccyang
 * @date 2018/7/5 13:10
 */
@Component
@Slf4j
//@EnableBinding(value = StreamClient.class)
public class StreamReceive {

//    @StreamListener(StreamClient.INPUT)
//    public void process(Object obj){
//        log.info("Stream Receive = {}" , obj);
//    }

}
