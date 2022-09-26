package com.fengwenyi.springboot.example.config;

import com.fengwenyi.springboot.example.filter.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-09-14
 */
@Configuration
public class MyFilterConfig {

    @Bean
    public FilterRegistrationBean myFilterBean() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new MyFilter());//设置为自定义的过滤器MyFilter
        filterRegistrationBean.addUrlPatterns("/*");//拦截所有请求
        filterRegistrationBean.setOrder(1);//优先级为1
        return filterRegistrationBean;
    }
    //可注册多个自定义的过滤器

}
