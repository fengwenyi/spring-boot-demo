package com.fengwenyi.demospringbootnettyclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-07-21
 */
@SpringBootApplication
public class DemoSpringBootNettyClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringBootNettyClientApplication.class, args);

        //启动netty客户端
        NettyClient nettyClient = new NettyClient();
        nettyClient.start();
    }

}
