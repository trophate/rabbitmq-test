package com.trophate.rabbitmqtest.base;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Q6Consumer {

    @RabbitListener(queues = "q6")
    public void process(String content) {
        System.out.println("q6:" + content);
    }
}
