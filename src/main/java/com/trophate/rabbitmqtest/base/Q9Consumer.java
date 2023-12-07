package com.trophate.rabbitmqtest.base;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Q9Consumer {

    @RabbitListener(queues = "#{q9.name}")
    public void process(String content) {
        System.out.println("q9:" + content);
    }
}
