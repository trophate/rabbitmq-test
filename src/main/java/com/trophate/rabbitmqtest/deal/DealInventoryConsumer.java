package com.trophate.rabbitmqtest.deal;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DealInventoryConsumer {

    @RabbitListener(queues = "deal_inventory")
    public void process(String s) {
        System.out.println(" ------- 完成库存扣减 -------");
    }
}
