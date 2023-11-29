package com.fengwenyi.demo.springboot.bean.condition;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2023-11-29
 */
@Configuration
public class ConditionBeanConfig {

    @AutoConfigureOrder(2)
    @Bean(name = "notebookPC")
    public Computer computer1() {
        return new Computer("笔记本电脑");
    }

    @AutoConfigureOrder(3)
    @ConditionalOnBean(Computer.class)
    // @ConditionalOnMissingBean(Computer.class)
    @Bean("notebookPC")
    public Computer computer2() {
        return new Computer("备用电脑");
    }

}
