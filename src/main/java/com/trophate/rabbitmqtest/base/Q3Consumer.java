package com.trophate.rabbitmqtest.base;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Q3Consumer {

    private static boolean sign = true;

    @RabbitListener(queues = "q3")
    public void process(String content) {
        System.out.println(content);
        if (sign) {
            sign = false;
            // 中断执行
            throw new RuntimeException();
        }
        sign = true;
    }
}
