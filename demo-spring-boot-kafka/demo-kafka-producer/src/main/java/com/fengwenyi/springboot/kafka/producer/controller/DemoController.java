package com.fengwenyi.springboot.kafka.producer.controller;

import com.fengwenyi.springboot.kafka.producer.KafkaSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-06-29
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    private final KafkaSender kafkaSender;

    public DemoController(KafkaSender kafkaSender) {
        this.kafkaSender = kafkaSender;
    }

    @RequestMapping("/send-kafka")
    public String sendKafka() {
        String msg = "this is a test msg.";
        kafkaSender.send(msg);
        return "Success";
    }

}
