package com.trophate.rabbitmqtest.deal;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DealPayConsumer {

    @RabbitListener(queues = "deal_pay")
    public void process(String s) {
        System.out.println("------- 完成支付 -------");
    }
}
