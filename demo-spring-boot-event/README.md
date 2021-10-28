# Spring Boot Event

## 描述

ApplicationContext 通过 ApplicationEvent 类和 ApplicationListener 接口进行事件处理。 如果将实现 ApplicationListener 接口的 bean 注入到上下文中，则每次使用 ApplicationContext 发布 ApplicationEvent 时，都会通知该 bean。 本质上，这是标准的观察者设计模式。

Spring的事件（Application Event）其实就是一个观察者设计模式，一个 Bean 处理完成任务后希望通知其它 Bean 或者说 一个Bean 想观察监听另一个Bean的行为。

Spring 事件只需要几步：

- 自定义事件，继承 ApplicationEvent
- 定义监听器，实现 ApplicationListener 或者通过 @EventListener 注解到方法上
- 定义发布者，通过 ApplicationEventPublisher

## 示例

用户登陆，通过事件的方式推送出去，日志系统可以用了记录用户登陆日志

### 代码示例

#### 定义用户登陆事件

```java
public class UserLoginEvent extends ApplicationEvent {
    public UserLoginEvent(Object source) {
        super(source);
    }
}
```

#### 推送

```java
@Component
public class MyPublisher {

    private final ApplicationContext applicationContext;

    public Publisher(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public void userLoginEvent(String username) {
        applicationContext.publishEvent(new UserLoginEvent(username));
    }
}
```

#### 监听

**方式一：**

```java
@Component
@Slf4j
public class MyListener {

    @EventListener
    public void onApplicationEvent(UserLoginEvent event) {
        // 记录用户登陆日志
        log.info("用户 {} 登陆", event.getSource());
    }

}
```

**方式二：**

```java
@Component
@Slf4j
public class UserLoginEventListener implements ApplicationListener<UserLoginEvent> {
    @Override
    public void onApplicationEvent(UserLoginEvent event) {
        // 记录用户登陆日志
        log.info("用户 {} 登陆", event.getSource());
    }
}
```

## 补充

### 1、多个监听

支持多个监听

### 2、同步

发布事件 -> 监听1-执行完成 -> 监听2-执行完成 -> ... -> 返回到发布事件，继续执行后面的方法

### 3、异步

如果需要异步支持，需要开启异步支持

`@EnableAsync` + `@Async`

主线程：发布事件 -> 监听1 -> 监听2 -> ... -> 返回到发布事件，继续执行后面的方法

异步线程1：监听1执行完成

异步线程2：监听1执行完成

### 4、可以不监听

可以只发布，不监听


### 5、Observer

ApplicationContext基于Observer模式（java.util包中有对应实现），提供了针对Bean的事件传
播功能。