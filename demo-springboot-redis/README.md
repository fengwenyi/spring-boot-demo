# Spring Boot Redis

## 依赖

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
```

## StringRedisTemplate

stringRedisTemplate.opsForValue().set(key, value);

value = stringRedisTemplate.opsForValue().get(key);

// 过期时间

stringRedisTemplate.opsForValue().set(key, value, 过期时间, 时间单位);

// 如果有值，不覆盖

stringRedisTemplate.opsForValue().setIfAbsent()