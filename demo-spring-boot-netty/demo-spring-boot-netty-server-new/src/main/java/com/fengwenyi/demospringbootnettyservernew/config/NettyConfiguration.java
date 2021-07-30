package com.fengwenyi.demospringbootnettyservernew.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-07-30
 */
@Configuration
@ConfigurationProperties(prefix = "netty.socket")
@Data
public class NettyConfiguration {

    private String ip;

    private Integer port;

}
