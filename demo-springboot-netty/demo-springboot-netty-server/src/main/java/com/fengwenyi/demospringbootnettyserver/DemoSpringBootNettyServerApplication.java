package com.fengwenyi.demospringbootnettyserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetSocketAddress;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-07-21
 */
@SpringBootApplication
public class DemoSpringBootNettyServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringBootNettyServerApplication.class, args);

        //启动服务端
        NettyServer nettyServer = new NettyServer();
        nettyServer.start(new InetSocketAddress("127.0.0.1", 8090));
    }

}
