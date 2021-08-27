# Spring Boot Logback

## 依赖

```
- logback
- slf4j
    - spring-boot-starter-logging
        - spring-boot-starter
            - spring-boot-starter-web
```

简单来说，就是 `spring-boot-starter-web` 依赖了 `spring-boot-starter`，

而 `spring-boot-starter` 依赖了 `spring-boot-starter-logging`

`spring-boot-starter-logging` 依赖了 `logback` + `slf4j`。

因此，我们只需要依赖 `spring-boot-starter-web` 就行了。


## 链接

- [springboot使用logback日志框架超详细教程](https://blog.csdn.net/white_ice/article/details/85065219)
- [spring boot日志分级别配置logback-spring.xml](https://blog.csdn.net/pm_mybook/article/details/87097451)