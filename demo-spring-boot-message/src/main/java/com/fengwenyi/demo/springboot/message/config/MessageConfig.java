package com.fengwenyi.demo.springboot.message.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.messaging.MessageChannel;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2023-11-27
 */
@Configuration
public class MessageConfig {

    @Bean("inputChannel")
    public MessageChannel inputChannel() {
        return new DirectChannel();
    }

    @Bean("queueChannel")
    public QueueChannel queueChannel() {
        QueueChannel queueChannel = MessageChannels.queue().get();
        return queueChannel;
    }

    @Bean
    public IntegrationFlow channelFlow() {
        return IntegrationFlows.from("inputChannel")
                .fixedSubscriberChannel()
                .channel("queueChannel")
                .get();
    }

}
