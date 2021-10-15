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


## 学习链接

- [Annotation Support for Scheduling and Asynchronous Execution](https://docs.spring.io/spring-framework/docs/current/reference/html/integration.html#scheduling-annotation-support)



## 总结

1、fixedDelay，间隔时间：上一次结束时间到下一次执行时间

2、fixedRate，间隔时间：上一次执行时间到下一次执行时间

3、fixedDelay，如果间隔时间小于任务时间，任务执行结束，间隔时间，再执行下一次

4、fixedRate，如果间隔时间小于任务时间，任务执行结束，立即再执行下一次
