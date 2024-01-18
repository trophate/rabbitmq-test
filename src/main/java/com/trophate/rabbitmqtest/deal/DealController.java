package com.trophate.rabbitmqtest.deal;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trophate.rabbitmqtest.result.Result;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deal")
public class DealController {

    private final RabbitTemplate rabbitTemplate;

    public DealController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    /**
     * 购买商品
     *
     * @return Result
     */
    @PostMapping("/buy")
    public Result buy() throws JsonProcessingException {
        Order order = Order.build();
        var objectMapper = new ObjectMapper();
        String orderJson = objectMapper.writeValueAsString(order);
        rabbitTemplate.convertAndSend("deal", "deal_inventory_k", orderJson);
        rabbitTemplate.convertAndSend("deal", "deal_pay_k", orderJson);
        rabbitTemplate.convertAndSend("deal", "deal_merchant_message_k", orderJson);
        return Result.success();
    }
}
