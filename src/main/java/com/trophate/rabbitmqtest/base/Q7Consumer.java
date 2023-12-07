package com.trophate.rabbitmqtest.base;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Q7Consumer {

    @RabbitListener(queues = "q7")
    public void process(String content) {
        System.out.println("q7:" + content);
    }
}
