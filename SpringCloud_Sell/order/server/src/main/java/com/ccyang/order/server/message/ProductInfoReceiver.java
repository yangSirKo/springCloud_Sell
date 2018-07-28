package com.ccyang.order.server.message;

import com.ccyang.order.server.utils.JsonUtil;
import com.ccyang.product.common.ProductInfoOutput;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ccyang
 * @date 2018/7/6 10:00
 */
@Component
@Slf4j
public class ProductInfoReceiver {

    private static String PRODUCT_STOCK_TEMPLATE = "product_stock_%s";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RabbitListener(queuesToDeclare = @Queue("decreaseStockQueue"))
    public void process(String message){
        // message => productInfoOutput
        List<ProductInfoOutput> productInfoOutputList = JsonUtil.fromJson(message,
                new TypeReference<List<ProductInfoOutput>>() {});
        log.info("从队列【{}】接收到消息：{}", "decreaseStockQueue", productInfoOutputList);

        // 存储到 redis 中
        for(ProductInfoOutput productInfoOutput : productInfoOutputList)
           stringRedisTemplate.opsForValue()
                .set(String.format(PRODUCT_STOCK_TEMPLATE, productInfoOutput.getProductId()),
                        String.valueOf(productInfoOutput.getProductStock()));
    }


}
