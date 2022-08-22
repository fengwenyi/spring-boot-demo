package com.fengwenyi.springboot.completablefuture.controller;

import com.fengwenyi.api.result.ResultTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-08-19
 */
@RestController
@RequestMapping("/demo")
@Slf4j
public class DemoController {

    private Executor asyncTaskExecutor;

    @Autowired
    public void setAsyncTaskExecutor(Executor asyncTaskExecutor) {
        this.asyncTaskExecutor = asyncTaskExecutor;
    }

    @GetMapping("/task")
    public ResultTemplate<?> task() {

        long startTime = System.currentTimeMillis();

        List<String> list = new ArrayList<>();

        ExecutorService executor = Executors.newFixedThreadPool(10);

        // task1
        CompletableFuture<String> task1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "task1";
        });

        // task2
        CompletableFuture<String> task2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "task2";
        }, executor);

        // task3
        CompletableFuture<String> task3 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "task3";
        }, executor);

        try {
            list.add(task1.get());
            list.add(task2.get());
            list.add(task3.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        log.info("task finished, time: [{}]ms", System.currentTimeMillis() - startTime);

        return ResultTemplate.success(list);
    }

    @GetMapping("/taskUseThreadPool")
    public ResultTemplate<?> taskUseThreadPool() {

        // task1
        CompletableFuture<String> task1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "task1";
        }, asyncTaskExecutor);


        return ResultTemplate.success();
    }

}
