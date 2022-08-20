package com.fengwenyi.springboot.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-08-20
 */
@Configuration
public class RabbitMQConfig {

    // item 交换机
    public static final String ITEM_TOPIC_EXCHANGE = "item_topic_exchange";

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


}
