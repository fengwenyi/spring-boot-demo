# Spring Boot Scheduled

## 使用步骤

1、启用注解 `@EnableScheduling`

2、设置任务 `@Scheduled(cron = "")`

## 设置定时的几种方式

### fixedDelay

间隔5秒执行一次

`@Scheduled(fixedDelay = 5000)`

新版本写法：

`@Scheduled(fixedDelay = 5, timeUnit = TimeUnit.SECONDS)`