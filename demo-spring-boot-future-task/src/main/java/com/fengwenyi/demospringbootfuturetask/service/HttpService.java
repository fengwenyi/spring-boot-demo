package com.fengwenyi.demospringbootfuturetask.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.concurrent.FutureTask;

/**
 * @author Erwin Feng
 * @since 2021-01-29
 */
@Service
@Slf4j
public class HttpService {

    @Autowired
    private ThreadPoolTaskExecutor defaultThreadPool;

    public FutureTask<String> http(String url, String param) {
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            log.info("httpService执行：" + url + "-" + param);
            Thread.sleep(3000);
            return url + "-" + param;
        });
        defaultThreadPool.execute(futureTask);
        return futureTask;
    }

}
