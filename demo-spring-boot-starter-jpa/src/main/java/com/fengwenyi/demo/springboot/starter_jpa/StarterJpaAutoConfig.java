package com.fengwenyi.demo.springboot.starter_jpa;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2023-11-21
 */
@Configuration
@ComponentScan(basePackageClasses = StarterJpaAutoConfig.class)
@EnableJpaRepositories("com.fengwenyi.demo.springboot.starter_jpa.repository")
@EntityScan("com.fengwenyi.demo.springboot.starter_jpa.entity")
public class StarterJpaAutoConfig {
}
