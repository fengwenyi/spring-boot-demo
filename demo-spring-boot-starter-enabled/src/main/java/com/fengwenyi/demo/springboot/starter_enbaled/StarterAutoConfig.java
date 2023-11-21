package com.fengwenyi.demo.springboot.starter_enbaled;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2023-11-21
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackageClasses = StarterAutoConfig.class)
public class StarterAutoConfig {
}
