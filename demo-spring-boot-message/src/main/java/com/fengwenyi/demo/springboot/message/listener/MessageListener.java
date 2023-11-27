package com.fengwenyi.demo.springboot.message.listener;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2023-11-27
 */
@Component
public class MessageListener {

    private final QueueChannel queueChannel;

    public MessageListener(QueueChannel queueChannel) {
        this.queueChannel = queueChannel;
    }

    @Bean
    public void receive() {
        Message<?> message = queueChannel.receive();
        String data = message.getPayload().toString();
        System.out.println(data);
    }

}
