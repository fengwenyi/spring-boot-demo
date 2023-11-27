package com.fengwenyi.demo.springboot.message.service;

import com.fengwenyi.demo.springboot.message.MessageApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2023-11-27
 */
public class MessageServiceTests extends MessageApplicationTests {

//    @Autowired
//    private IMessageService messageService;

    @Autowired
    private MessageChannel inputChannel;

//    @Autowired
//    private QueueChannel queueChannel;

//    @Test
    public void testSend() {
//        messageService.send("这是要数据的数据");
        Message<String> sendMessage = MessageBuilder.withPayload("123456").build();
        inputChannel.send(sendMessage);
        System.out.println("消息发送成功");
//        Message<?> message = queueChannel.receive();
//        String data = message.getPayload().toString();
//        System.out.println(data);
    }

}
