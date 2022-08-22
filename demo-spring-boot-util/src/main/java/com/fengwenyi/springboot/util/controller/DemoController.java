package com.fengwenyi.springboot.util.controller;

import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-08-22
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/stopWatch")
    public String stopWatch() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        try {
            Thread.sleep(3*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        stopWatch.stop();
        // String time = stopWatch.prettyPrint();
        /*
StopWatch '': running time = 3003901894 ns
---------------------------------------------
ns         %     Task name
---------------------------------------------
3003901894  100%
         */
        double totalTimeSeconds = stopWatch.getTotalTimeSeconds();
        System.out.println(totalTimeSeconds);
        return "success";
    }

}
