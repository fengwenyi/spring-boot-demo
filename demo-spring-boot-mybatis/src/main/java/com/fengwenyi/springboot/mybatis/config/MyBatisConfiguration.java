package com.fengwenyi.springboot.mybatis.config;

import com.fengwenyi.springboot.mybatis.plugin.MyPagePlugin;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-11-14
 */
@Configuration
public class MyBatisConfiguration {

//    @Bean
    public MyPagePlugin myPagePlugin(){
        return new MyPagePlugin();
    }

    // 注册插件方式2
    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return configuration -> {
            //插件拦截链采用了责任链模式，执行顺序和加入连接链的顺序有关
            MyPagePlugin myPagePlugin = new MyPagePlugin();
            configuration.addInterceptor(myPagePlugin);
        };
    }
}
