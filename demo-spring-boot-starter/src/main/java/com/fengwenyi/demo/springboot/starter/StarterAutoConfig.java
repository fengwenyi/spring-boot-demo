package com.fengwenyi.demo.springboot.starter;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2023-11-21
 */
@Configuration
@ComponentScan(basePackageClasses = StarterAutoConfig.class)
public class StarterAutoConfig {
}
