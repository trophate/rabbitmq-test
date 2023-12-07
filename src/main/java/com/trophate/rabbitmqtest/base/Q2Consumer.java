package com.trophate.rabbitmqtest.base;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Q2Consumer {

    private static int aNum = 0;
    private static int bNum = 0;

    @RabbitListener(queues = "q2")
    public void process1(String content) throws InterruptedException {
        System.out.println("a(" + ++aNum + "): " + content);
        Thread.sleep(1000);
    }

    @RabbitListener(queues = "q2")
    public void process2(String content) throws InterruptedException {
        System.out.println("b(" + ++bNum + "): " + content);
        Thread.sleep(1500);
    }

    public static void reset() {
        aNum = 0;
        bNum = 0;
    }
}
