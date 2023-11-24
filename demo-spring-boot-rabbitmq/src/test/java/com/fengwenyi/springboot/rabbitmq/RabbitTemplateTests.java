package com.fengwenyi.springboot.rabbitmq;

import com.fengwenyi.springboot.rabbitmq.config.RabbitMQConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2023-11-24
 */
@Slf4j
public class RabbitTemplateTests extends RabbitMQApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSendMultipleConsumerMsg() {
        rabbitTemplate.convertAndSend(RabbitMQConfig.FANOUT_EXCHANGE_DEMO, "", "这是一条可以被多端消费的消息");
    }

}
