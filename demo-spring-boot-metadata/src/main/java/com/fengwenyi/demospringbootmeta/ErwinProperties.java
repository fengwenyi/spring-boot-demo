package com.fengwenyi.demospringbootmeta;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-09-29
 */
@Data
@Configuration
@ConfigurationProperties("erwin")
public class ErwinProperties {
}
