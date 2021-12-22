package com.fengwenyi.demospringbootwebservice.service.impl;

import com.fengwenyi.demospringbootwebservice.service.IDemoService;
import com.fengwenyi.demospringbootwebservice.util.WebServiceUtils;
import com.fengwenyi.javalib.generate.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-12-22
 */
@Service
@Slf4j
public class DemoServiceImpl implements IDemoService {
    @Override
    @Async
    public void hello() {
        String url = "http://localhost:9103/ws/testService?wsdl";
//        String url = "http://10.255.23.21:6060/ws/testService?wsdl";
        String method = "hello";
        String param = "";
        long timeout = 45_000;
        String id = IdUtils.genId();
        log.info("请求开始 - {}", id);
        String result = WebServiceUtils.call(url, method, param, timeout);
        log.info("请求结束 - {} : {}", id, result);
    }

    @Autowired
    private WebServiceTemplate webServiceTemplate;


    @Override
    public void template() {
        String url = "http://localhost:9103/ws/testService?wsdl";
//        String url = "http://10.255.23.21:6060/ws/testService?wsdl";
        String method = "hello";
        String param = "";
        String id = IdUtils.genId();
        log.info("请求开始 - {}", id);
        Object result = webServiceTemplate.marshalSendAndReceive(url, method);
        log.info("请求结束 - {} : {}", id, result);
    }
}
