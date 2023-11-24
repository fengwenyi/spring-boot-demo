package com.fengwenyi.springboot.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-08-20
 */
@Configuration
public class RabbitMQConfig {

    // item 交换机
    public static final String ITEM_TOPIC_EXCHANGE = "item_topic_exchange";
    public static final String FANOUT_EXCHANGE_DEMO = "fanout_exchange_demo";

    // item 队列
    public static final String ITEM_QUEUE = "item_queue";

    // 声明交换机
    @Bean
    public Exchange itemTopicExchange() {
        return ExchangeBuilder.topicExchange(ITEM_TOPIC_EXCHANGE).durable(true).build();
    }

    // 声明队列
    @Bean
    public Queue itemQueue() {
        return QueueBuilder.durable(ITEM_QUEUE).build();
    }

    // 绑定队列和交换机
    @Bean
    public Binding itemQueueExchange(@Qualifier("itemQueue") Queue queue,
                                     @Qualifier("itemTopicExchange") Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("item.#").noargs();
    }

    /**
     * 延时队列交换机
     * 注意这里的交换机类型：CustomExchange
     *
     * @return
     */
    @Bean
    public CustomExchange delayExchange() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-delayed-type", "direct");
        //属性参数 交换机名称 交换机类型 是否持久化 是否自动删除 配置参数
        return new CustomExchange("delay_exchange", "x-delayed-message", true, false, args);
    }

    /**
     * 延时队列
     *
     * @return
     */
    @Bean
    public Queue delayQueue() {
        //属性参数 队列名称 是否持久化
        return new Queue("delay_queue", true);
    }

    /**
     * 给延时队列绑定交换机
     *
     * @return
     */
    @Bean
    public Binding cfgDelayBinding() {
        return BindingBuilder.bind(delayQueue()).to(delayExchange()).with("delay_key").noargs();
    }


    // -------------------------------------------------------------------

    @Bean
    public FanoutExchange demoFanoutExchange() {
        // return new FanoutExchange(FANOUT_EXCHANGE_DEMO,true, false);
        return ExchangeBuilder
                .fanoutExchange(FANOUT_EXCHANGE_DEMO)
                .durable(false) // 不持久化数据
                .autoDelete() // 解绑删除
                .build();
    }

    @Bean
    public Queue consumer01Queue() {
        return QueueBuilder.durable("queue_consumer01").build();
    }

    @Bean
    public Binding consumer01QueueDemoFanoutExchangeBinding() {
        return BindingBuilder
                .bind(consumer01Queue())
                .to(demoFanoutExchange())
                ;
    }

    @Bean
    public Queue consumer02Queue() {
        return QueueBuilder.durable("queue_consumer02").build();
    }

    @Bean
    public Binding consumer02QueueDemoFanoutExchangeBinding() {
        return BindingBuilder
                .bind(consumer02Queue())
                .to(demoFanoutExchange())
                ;
    }

}
