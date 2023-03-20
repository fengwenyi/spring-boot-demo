package com.fengwenyi.springboot.example.mybais;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2023-03-14
 */
@Slf4j
public class MyBatisMapperScannerRegistrar implements ImportBeanDefinitionRegistrar, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // ImportBeanDefinitionRegistrar.super.registerBeanDefinitions(importingClassMetadata, registry);
        log.info("===> MyBatisMapperScannerRegistrar > registerBeanDefinitions");

        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(MyBatisMapperScannerConfigurer.class);

        // builder.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);

        builder.addPropertyValue("basePackages", new String[]{ "com.fengwenyi.springboot.example.mybais.mapper" });

        String beanName = generateBaseBeanName(importingClassMetadata, 0);

        registry.registerBeanDefinition(beanName, builder.getBeanDefinition());

//        Object userMapper = applicationContext.getBean("userMapper");
//        log.info("===> userMapper: " + userMapper);


    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    private static String generateBaseBeanName(AnnotationMetadata importingClassMetadata, int index) {
        return importingClassMetadata.getClassName() + "#" + MyBatisMapperScannerRegistrar.class.getSimpleName() + "#" + index;
    }
}
