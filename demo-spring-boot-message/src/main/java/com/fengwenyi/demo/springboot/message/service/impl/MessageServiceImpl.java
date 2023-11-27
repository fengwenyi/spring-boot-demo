package com.fengwenyi.demo.springboot.message.service.impl;

import com.fengwenyi.demo.springboot.message.service.IMessageService;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2023-11-27
 */
@Service
public class MessageServiceImpl implements IMessageService {

    private final MessageChannel inputChannel;

    public MessageServiceImpl(MessageChannel inputChannel) {
        this.inputChannel = inputChannel;
    }

    @Override
    public void send(String data) {
        System.out.println("1");
        Message<String> message = MessageBuilder.withPayload(data).build();
        System.out.println("2");
        inputChannel.send(message);
        System.out.println("消息发送成功");
    }

}
