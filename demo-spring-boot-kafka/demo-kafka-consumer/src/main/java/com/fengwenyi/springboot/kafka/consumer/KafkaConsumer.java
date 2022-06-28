package com.fengwenyi.springboot.kafka.consumer;

import com.fengwenyi.springboot.kafka.sdk.KafkaTopic;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-06-29
 */
@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = {KafkaTopic.DEMO_KAFKA})
    public void listen(ConsumerRecord<?, ?> record) {

        Optional.ofNullable(record.value())
                .ifPresent(message -> {
                    log.info("【+++++++++++++++++ record = {} 】", record);
                    log.info("【+++++++++++++++++ message = {}】", message);
                });
    }

}
