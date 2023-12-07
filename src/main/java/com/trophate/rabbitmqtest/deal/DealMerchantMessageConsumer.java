package com.trophate.rabbitmqtest.deal;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DealMerchantMessageConsumer {

    @RabbitListener(queues = "deal_merchant_message")
    public void process(String s) throws JsonProcessingException {
        var objectMapper = new ObjectMapper();
        Order order = objectMapper.readValue(s, Order.class);
        System.out.println("------- 用户 " + order.getBuyerName() + " 购买了商品 " + order.getProductName() + " / " + order.getNum() + " 件" + ", 请尽快发货. -------");
    }
}
