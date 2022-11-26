# Spring Boot 整合 MyBatis

## 整合流程

### 依赖

```groovy
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.0'
    runtimeOnly 'mysql:mysql-connector-java'
}
```

### 配置

```yaml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/demo-spring-boot-mybatis
    username: root
    password: 123456

mybatis:
  type-aliases-package: com.fengwenyi.springboot.mybatis.entity
  mapper-locations: classpath:mapper/*.xml
```

### 实体类

略

### mapper 接口

略

### mapper xml 文件

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="com.fengwenyi.springboot.mybatis.mapper.IUserMapper" >
</mapper>
```

### 扫描 Mapper 接口

方法一：使用 `@MapperScan("com.fengwenyi.springboot.mybatis.mapper")`。

方法二：在 Mapper 接口上添加注解 `@Mapper`。



## 问题

- 使用 `org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.2` 包报错

需要使用新包：

implementation 'org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.0'