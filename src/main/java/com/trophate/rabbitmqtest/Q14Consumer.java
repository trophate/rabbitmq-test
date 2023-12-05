package com.trophate.rabbitmqtest;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Q14Consumer {

    @RabbitListener(queues = "q14")
    public String process(String content) {
        System.out.println(content);
        System.out.println("远程函数已执行");
        return "远程函数返回";
    }
}
