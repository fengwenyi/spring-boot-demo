package com.fengwenyi.demo.springboot.message.controller;

import com.fengwenyi.demo.springboot.message.service.IMessageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2023-11-27
 */
@RestController
@RequestMapping("/test")
public class TestController {

    private final IMessageService messageService;

    public TestController(IMessageService messageService) {
        this.messageService = messageService;
    }

    @RequestMapping("/send-message")
    public void testSendMessage() {
        messageService.send("这是要发送的消息");
    }

}
