package com.fengwenyi.demo.springboot.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2023-03-06
 */
public class User implements InitializingBean, BeanNameAware, DisposableBean, ApplicationContextAware {

    private Integer id;
    private String name;

    public User() {
    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
        System.out.println("2. 调用构造函数");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
        System.out.println("5. 属性注入 id");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("5. 属性注入 name");
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    // init-method
    @PostConstruct
    public void init() {
        System.out.println("10. user init-method");
    }

    // init-destroy
    @PreDestroy
    public void preDestroy() {
        System.out.println("13. user destroy-method");
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("6. 调用 BeanNameAware.setBeanName() 方法");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("7. 调用 BeanNameAware.setBeanName() 方法");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("12. 调用 DisposableBean.destroy() 方法");
    }
}
