package com.fengwenyi.demospringbootfuturetask.service.impl;

import com.fengwenyi.demospringbootfuturetask.service.HttpService;
import com.fengwenyi.javalib.generate.MathUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2022-05-13
 */
@Slf4j
@Service
public class HttpServiceImpl implements HttpService {

    @Autowired
    private ThreadPoolTaskExecutor defaultThreadPool;

    public FutureTask<String> http(String url, String param) {
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            double v = MathUtils.randomNum(5, 1);
            log.info("httpService执行：" + url + "-" + param + "-" + v);

            Thread.sleep(((int) v) * 1000);
            return url + "-" + param;
        });
        defaultThreadPool.execute(futureTask);
        return futureTask;
    }

    @Async
    public Future<String> http2(String url, String param) {
        double v = MathUtils.randomNum(5, 1);
        int n = (int) v;
        log.info("httpService执行：" + url + "-" + param + "-" + n);

        try {
            Thread.sleep(n * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String result = url + "-" + param;
        return new AsyncResult<>(result);
    }

}
