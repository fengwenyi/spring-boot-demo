package com.fengwenyi.springboot.rabbitmq.listener;

import com.fengwenyi.springboot.rabbitmq.config.RabbitMQConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-08-20
 */
@Component
@Slf4j
public class MyListener {

    @RabbitListener(queues = RabbitMQConfig.ITEM_QUEUE)
    public void receiveMsg(String msg) {
        log.info("receive msg: [{}]", msg);
    }

}
