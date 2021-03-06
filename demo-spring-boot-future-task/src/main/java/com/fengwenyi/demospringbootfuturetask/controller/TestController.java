package com.fengwenyi.demospringbootfuturetask.controller;

import com.fengwenyi.demospringbootfuturetask.service.HttpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author Erwin Feng
 * @since 2021-01-29
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Autowired
    private HttpService httpService;

    @GetMapping("/http")
    public String http() {
        long startTime = System.currentTimeMillis();
        List<FutureTask<String>> taskList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            FutureTask<String> futureTask = httpService.http("url" + i, "param" + i);
            taskList.add(futureTask);
        }
        taskList.forEach(stringFutureTask -> {
            try {
                log.info(stringFutureTask.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
        long endTime = System.currentTimeMillis();
        log.info("耗时：[{}]ms", endTime - startTime);
        return "test http finish";
    }

    @GetMapping("/http2")
    public String http2() {
        long startTime = System.currentTimeMillis();
        List<Future<String>> taskList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<String> futureTask = httpService.http2("url" + i, "param" + i);
            taskList.add(futureTask);
        }
        taskList.forEach(stringFutureTask -> {
            try {
                log.info(stringFutureTask.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
        long endTime = System.currentTimeMillis();
        log.info("耗时：[{}]ms", endTime - startTime);
        return "test http finish";
    }

}
