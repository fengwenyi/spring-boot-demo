# Spring Boot Redisson

## Redisson

```xml
<dependency>
    <groupId>org.redisson</groupId>
    <artifactId>redisson</artifactId>
    <version>${redisson.version}</version>
</dependency>
```


## Redisson Starter

```xml
<dependency>
    <groupId>org.redisson</groupId>
    <artifactId>redisson-spring-boot-starter</artifactId>
    <version>${redisson.version}</version>
</dependency>
```

配置：

```yaml
spring:
  redis:
    redisson:
      config: |
        # 单节点配置
        singleServerConfig:
          # 节点地址
          address: redis://127.0.0.1:6379
```

也可以单独配置

```yaml
spring:
  redis:
    redisson:
      file: classpath:redisson.yml
```