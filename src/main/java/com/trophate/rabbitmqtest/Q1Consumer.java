package com.trophate.rabbitmqtest;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消费者
 */
@Component
public class Q1Consumer {

    @RabbitListener(queues = "q1")
    public void process(String content) {
        System.out.println(content);
    }
}
