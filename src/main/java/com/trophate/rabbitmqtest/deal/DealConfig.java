package com.trophate.rabbitmqtest.deal;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DealConfig {

    @Bean
    public DirectExchange dealExchange() {
        return ExchangeBuilder.directExchange("deal")
                .build();
    }

    /**
     * 订单队列, 用于库存扣减.
     *
     * @return Queue
     */
    @Bean
    public Queue dealInventory() {
        return QueueBuilder.nonDurable("deal_inventory")
                .build();
    }

    @Bean
    public Binding dealInventoryBind() {
        return BindingBuilder.bind(dealInventory()).to(dealExchange()).with("deal_inventory_k");
    }

    /**
     * 订单队列, 用于支付.
     *
     * @return Queue
     */
    @Bean
    public Queue dealPay() {
        return QueueBuilder.nonDurable("deal_pay")
                .build();
    }

    @Bean
    public Binding dealPayBind() {
        return BindingBuilder.bind(dealPay()).to(dealExchange()).with("deal_pay_k");
    }

    /**
     * 订单队列, 用于通知商家发货.
     *
     * @return Queue
     */
    @Bean
    public Queue dealMerchantMessage() {
        return QueueBuilder.nonDurable("deal_merchant_message")
                .build();
    }

    @Bean
    public Binding dealMerchantMessageBind() {
        return BindingBuilder.bind(dealMerchantMessage()).to(dealExchange()).with("deal_merchant_message_k");
    }
}
