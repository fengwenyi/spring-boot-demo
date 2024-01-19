package com.fengwenyi.demo.springboot.aop.controller;

import com.fengwenyi.demo.springboot.aop.annotation.MyAop;
import com.fengwenyi.demo.springboot.aop.annotation.MyFirstAop;
import com.fengwenyi.demo.springboot.aop.annotation.MySecondAop;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2024-01-11
 */
@RestController
@RequestMapping("/sample")
@Slf4j
public class SampleController {

    @MySecondAop
    @MyFirstAop
    @RequestMapping("/aop-order")
    public String aopOrder() {
        log.info("SampleController#aopOrder");
        return "aopOrder";
    }

    @MyAop
    @RequestMapping("/my-api")
    public String myApi() {
        return "success";
    }

    @RequestMapping("/my-api2")
    public String myApi2() {
        return "success";
    }

}
