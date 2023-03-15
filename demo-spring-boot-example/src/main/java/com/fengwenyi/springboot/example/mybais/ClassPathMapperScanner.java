package com.fengwenyi.springboot.example.mybais;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

import java.util.Set;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2023-03-15
 */
@Slf4j
public class ClassPathMapperScanner extends ClassPathBeanDefinitionScanner {

    private Class<? extends MyBatisMapperFactoryBean> mapperFactoryBeanClass = MyBatisMapperFactoryBean.class;

    public Class<? extends MyBatisMapperFactoryBean> getMapperFactoryBeanClass() {
        return mapperFactoryBeanClass;
    }

    public void setMapperFactoryBeanClass(Class<? extends MyBatisMapperFactoryBean> mapperFactoryBeanClass) {
        this.mapperFactoryBeanClass = mapperFactoryBeanClass;
    }

    public ClassPathMapperScanner(BeanDefinitionRegistry registry) {
        super(registry);
    }

    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {

        log.info("===> ClassPathMapperScanner > #doScan");

        Set<BeanDefinitionHolder> definitionHolders = super.doScan(basePackages);

        for (BeanDefinitionHolder holder : definitionHolders) {
            AbstractBeanDefinition beanDefinition = (AbstractBeanDefinition) holder.getBeanDefinition();
            beanDefinition.setBeanClass(mapperFactoryBeanClass);
        }

        return definitionHolders;
    }
}
