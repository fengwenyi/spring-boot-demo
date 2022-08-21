package com.fengwenyi.springboot.rabbitmq.listener;

import com.fengwenyi.springboot.rabbitmq.config.RabbitMQConfig;
import com.fengwenyi.springboot.rabbitmq.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-08-20
 */
@Component
@Slf4j
public class MyListener {

    @RabbitListener(queues = RabbitMQConfig.ITEM_QUEUE)
    public void receiveMsgByItemQueue(String msg) {
        log.info("==>receive msg: [{}]", msg);
    }


    //监听消息队列
    @RabbitListener(queues = "delay_queue")
    public void receiveMsgByDelayQueue(String msg) throws IOException {
        log.info("==>receive msg: [{}]", Order.to(msg));
    }

}
