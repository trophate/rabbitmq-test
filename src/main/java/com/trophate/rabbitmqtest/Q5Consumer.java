package com.trophate.rabbitmqtest;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Q5Consumer {

    private static int aNum = 0;
    private static int bNum = 0;

    @RabbitListener(queues = "q5")
    public void process1(String content) throws InterruptedException {
        System.out.println("a(" + ++aNum + "): " + content);
        Thread.sleep(300);
    }

    @RabbitListener(queues = "q5")
    public void process2(String content) {
        System.out.println("b(" + ++bNum + "): " + content);
    }

    public static void reset() {
        aNum = 0;
        bNum = 0;
    }
}
