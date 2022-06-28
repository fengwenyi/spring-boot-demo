package com.fengwenyi.springboot.kafka.producer;

import com.fengwenyi.javalib.convert.JsonUtils;
import com.fengwenyi.javalib.generate.IdUtils;
import com.fengwenyi.springboot.kafka.sdk.KafkaTopic;
import com.fengwenyi.springboot.kafka.sdk.MessageModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-06-29
 */
@Slf4j
@Component
public class KafkaSender {

    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public void setKafkaTemplate(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public <T> void send(T data) {
        MessageModel<T> messageModel = new MessageModel<>();
        messageModel.setId(IdUtils.genId());
        messageModel.setData(data);
        messageModel.setSendTime(LocalDateTime.now());
        String message = JsonUtils.convertString(messageModel);
        kafkaTemplate.send(KafkaTopic.DEMO_KAFKA, message);
    }

}
