package com.fengwenyi.demospringbootaop.controller;

import com.fengwenyi.demospringbootaop.annotation.MyFirstAop;
import com.fengwenyi.demospringbootaop.annotation.MySecondAop;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2024-01-11
 */
@RestController
@RequestMapping("/sample")
public class SampleController {

    @MySecondAop
    @MyFirstAop
    @RequestMapping("/aop-order")
    public String aopOrder() {
        return "aopOrder";
    }

}
