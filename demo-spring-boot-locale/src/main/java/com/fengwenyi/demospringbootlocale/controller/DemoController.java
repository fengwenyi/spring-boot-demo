package com.fengwenyi.demospringbootlocale.controller;

import com.fengwenyi.demospringbootlocale.service.IMessageService;
import com.fengwenyi.demospringbootlocale.util.I18nUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-12-30
 */
@RestController
public class DemoController {

    private IMessageService messageService;

    @Autowired
    public void setMessageService(IMessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/hello")
    public String hello(String name) {
//        return I18nUtils.getMessage("hello", new String[] { name });
        return messageService.getMessage("hello", new String[] { name });

    }

}
