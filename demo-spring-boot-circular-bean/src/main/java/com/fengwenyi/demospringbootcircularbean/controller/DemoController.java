package com.fengwenyi.demospringbootcircularbean.controller;

import com.fengwenyi.demospringbootcircularbean.service.ICircularAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Erwin Feng
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private ICircularAService iCircularAService;

    @GetMapping("/circular")
    public String circular() {
        iCircularAService.helloA();
        return "finish!";
    }

}
