package com.fengwenyi.demospringbootwebservice.service.impl;

import com.fengwenyi.demospringbootwebservice.service.ITestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-12-22
 */
@Slf4j
@Service
@WebService(serviceName = "testService", // 与接口中指定的name一致
        targetNamespace = "http://service.demospringbootwebservice.fengwenyi.com", // 与接口中的命名空间一致,一般是接口的包名倒
        endpointInterface = "com.fengwenyi.demospringbootwebservice.service.ITestService"// 接口地址
)
public class TestServiceImpl implements ITestService {
    @Override
    public String hello() {
        String id = UUID.randomUUID().toString();

        log.info(">>>>>>>>>>>>>>>>>>>>>>> request - {}", id);

        try {
            Thread.sleep(60 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("<<<<<<<<<<<<<<<<<<<<< response - {}", id);

        return "Hello " + LocalDateTime.now();
    }
}
