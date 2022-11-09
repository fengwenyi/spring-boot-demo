package com.fengwenyi.springboot.dynamictp.controller;

import com.dtp.core.DtpRegistry;
import com.dtp.core.thread.DtpExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-11-08
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private ThreadPoolExecutor dtpExecutor1;

    @GetMapping("/task")
    public String task() {
//        dtpExecutor1.execute(() -> System.out.println("test"));
        System.out.println(dtpExecutor1.getCorePoolSize());
        dtpExecutor1.setCorePoolSize(10);
        System.out.println(dtpExecutor1.getCorePoolSize());
//        DtpExecutor dtpExecutor = DtpRegistry.getDtpExecutor("dtpExecutor1");
//        dtpExecutor.execute(() -> System.out.println("test"));
        return "success";



    }

}
