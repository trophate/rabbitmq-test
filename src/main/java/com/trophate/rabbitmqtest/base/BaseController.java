package com.trophate.rabbitmqtest.base;

import com.trophate.rabbitmqtest.result.Result;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    private final RabbitTemplate rabbitTemplate;

    public BaseController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    /**
     * 简单使用
     *
     * @return Result
     */
    @PostMapping("/t1")
    public Result t1() {
        // 生产者
        rabbitTemplate.convertAndSend("toQ1", "消息");
        return Result.success();
    }

    /**
     * 多消费者
     *
     * @return Result
     */
    @PostMapping("/t2")
    public Result t2() {
        Q2Consumer.reset();
        for (int i = 1; i <= 20; i++) {
            rabbitTemplate.convertAndSend("e1", "toQ2", ("消息" + i));
        }
        return Result.success();
    }

    /**
     * 消息确认
     *
     * @return Result
     */
    @PostMapping("/t3")
    public Result t3() {
        rabbitTemplate.convertAndSend("e1", "toQ3", "消息");
        return Result.success();
    }

    /**
     * 消息持久化
     *
     * @return Result
     */
    @PostMapping("/t4")
    public Result t4() {
        var messageProperties = new MessageProperties();
        messageProperties.setDeliveryMode(MessageDeliveryMode.PERSISTENT);
        rabbitTemplate.send("e1", "toQ4", new Message("消息".getBytes(), messageProperties));
        return Result.success();
    }

    /**
     * 公平分发
     *
     * @return Result
     */
    @PostMapping("/t5")
    public Result t5() {
        Q5Consumer.reset();
        for (int i = 1; i <= 20; i++) {
            rabbitTemplate.convertAndSend("e1", "toQ5", i);
        }
        return Result.success();
    }

    /**
     * 发布/订阅
     *
     * @return Result
     */
    @PostMapping("/t6")
    public Result t6() {
        rabbitTemplate.convertAndSend("e2", "", "发布消息");
        return Result.success();
    }

    /**
     * 发布/订阅
     *
     * @return Result
     */
    @PostMapping("/t8")
    public Result t8() {
        rabbitTemplate.convertAndSend("e3", "", "消息");
        return Result.success();
    }

    /**
     * 直连交换机(路由)
     *
     * @return Result
     */
    @PostMapping("/t10")
    public Result t10() {
        rabbitTemplate.convertAndSend("e4", "toQ10", "消息");
        rabbitTemplate.convertAndSend("e4", "toQ11a", "消息");
        rabbitTemplate.convertAndSend("e4", "toQ11b", "消息");
        return Result.success();
    }

    /**
     * 主题交换机
     *
     * @return Result
     */
    @PostMapping("/t12")
    public Result t12() {
        rabbitTemplate.convertAndSend("e5", "apple.red.small", "消息");
        rabbitTemplate.convertAndSend("e5", "banana.yellow.big", "消息");
        return Result.success();
    }

    /**
     * RPC客户端
     *
     * @return Result
     */
    @PostMapping("/t14")
    public Result t14() {
        String res = (String) rabbitTemplate.convertSendAndReceive("e6", "rpc", "请求执行远程函数");
        System.out.println(res);
        return Result.success();
    }
}
