package com.trophate.rabbitmqtest;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Q8Consumer {

    // 绑定临时队列
    @RabbitListener(queues = "#{q8.name}")
    public void process(String content) {
        System.out.println("q8:" + content);
    }
}
