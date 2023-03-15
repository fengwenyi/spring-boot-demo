package com.fengwenyi.springboot.example.mybais;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2023-03-15
 */
@Slf4j
public class MyBatisMapperFactoryBean<T> implements FactoryBean<T> {

    private Class<T> clazz;
    private String beanClassName;

    @Override
    public T getObject() throws Exception {

        log.info("===> MyBatisMapperFactoryBean > #getObject");

        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return clazz;
    }
}
