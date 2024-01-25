package com.trophate.rabbitmqtest.base;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseConfig {

    /**
     * 构建交换机
     *
     * @return DirectExchange
     */
    @Bean
    public DirectExchange e1() {
        return ExchangeBuilder.directExchange("e1")
                .build();
    }

    /**
     * 构建队列
     *
     * @return Queue
     */
    @Bean
    public Queue q1() {
        return QueueBuilder.nonDurable("q1")
                .build();
    }

    /**
     * 将交换机与队列绑定
     *
     * @return Binding
     */
    @Bean
    public Binding b1() {
        return BindingBuilder.bind(q1()).to(e1()).with("toQ1");
    }



    @Bean
    public Queue q2() {
        return QueueBuilder.nonDurable("q2")
                .build();
    }

    @Bean
    public Binding b2() {
        return BindingBuilder.bind(q2()).to(e1()).with("toQ2");
    }



    @Bean
    public Queue q3() {
        return QueueBuilder.nonDurable("q3")
                .build();
    }

    @Bean
    public Binding b3() {
        return BindingBuilder.bind(q3()).to(e1()).with("toQ3");
    }



    /**
     * 持久化队列
     *
     * @return Queue
     */
    @Bean
    public Queue q4() {
        return QueueBuilder.durable("q4")
                .build();
    }

    @Bean
    public Binding b4() {
        return BindingBuilder.bind(q4()).to(e1()).with("toQ4");
    }



    @Bean
    public Queue q5() {
        return QueueBuilder.nonDurable("q5")
                .build();
    }

    @Bean
    public Binding b5() {
        return BindingBuilder.bind(q5()).to(e1()).with("toQ5");
    }



    /**
     * 扇形交换机
     *
     * @return FanoutExchange
     */
    @Bean
    public FanoutExchange e2() {
        return ExchangeBuilder.fanoutExchange("e2")
                .build();
    }

    @Bean
    public Queue q6() {
        return QueueBuilder.nonDurable("q6")
                .build();
    }

    @Bean
    public Binding b6() {
        return BindingBuilder.bind(q6()).to(e2());
    }

    @Bean
    public Queue q7() {
        return QueueBuilder.nonDurable("q7")
                .build();
    }

    @Bean
    public Binding b7() {
        return BindingBuilder.bind(q7()).to(e2());
    }



    @Bean
    public FanoutExchange e3() {
        return ExchangeBuilder.fanoutExchange("e3")
                .build();
    }

    /**
     * 临时队列
     *
     * @return Queue
     */
    @Bean
    public Queue q8() {
        return new AnonymousQueue();
    }

    @Bean
    public Binding b8() {
        return BindingBuilder.bind(q8()).to(e3());
    }

    @Bean
    public Queue q9() {
        return new AnonymousQueue();
    }

    @Bean
    public Binding b9() {
        return BindingBuilder.bind(q9()).to(e3());
    }



    @Bean
    public DirectExchange e4() {
        return ExchangeBuilder.directExchange("e4")
                .build();
    }

    @Bean
    public Queue q10() {
        return QueueBuilder.nonDurable("q10")
                .build();
    }

    @Bean
    public Binding b10() {
        return BindingBuilder.bind(q10()).to(e4()).with("toQ10");
    }

    @Bean
    public Queue q11() {
        return QueueBuilder.nonDurable("q11")
                .build();
    }

    @Bean
    public Binding b11a() {
        return BindingBuilder.bind(q11()).to(e4()).with("toQ11a");
    }

    @Bean
    public Binding b11b() {
        return BindingBuilder.bind(q11()).to(e4()).with("toQ11b");
    }


    /**
     * 主题交换机
     *
     * @return TopicExchange
     */
    @Bean
    public TopicExchange e5() {
        return ExchangeBuilder.topicExchange("e5")
                .build();
    }

    @Bean
    public Queue q12() {
        return QueueBuilder.nonDurable("q12")
                .build();
    }

    @Bean
    public Binding b12() {
        // *表示一个任意词
        return BindingBuilder.bind(q12()).to(e5()).with("*.red.*");
    }

    @Bean
    public Queue q13() {
        return QueueBuilder.nonDurable("q13")
                .build();
    }

    @Bean
    public Binding b13a() {
        return BindingBuilder.bind(q13()).to(e5()).with("apple.*.*");
    }

    @Bean
    public Binding b13b() {
        // #表示一个或多个任意词
        return BindingBuilder.bind(q13()).to(e5()).with("#.big");
    }



    @Bean
    public DirectExchange e6() {
        return ExchangeBuilder.directExchange("e6")
                .build();
    }

    @Bean
    public Queue q14() {
        return QueueBuilder.nonDurable("q14")
                .build();
    }

    @Bean
    public Binding b14() {
        return BindingBuilder.bind(q14()).to(e6()).with("rpc");
    }
}
