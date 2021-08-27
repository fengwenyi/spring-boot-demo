```
Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
LogExecutionTime annotation = method.getAnnotation(LogExecutionTime.class);
String key = annotation.key();
String cacheName = annotation.cacheName();
boolean needLog = annotation.needLog();
```

```
@Around("@annotation(com.fengwenyi.springbootaopdemo.annotation.LogExecutionTime)")
    public Object logExecutionTime1(ProceedingJoinPoint joinPoint) throws Throwable {
```


execution(* com.sample.service.impl..*.*(..))

解释如下：



符号	含义
execution（）	表达式的主体；
第一个”*“符号	表示返回值的类型任意；
com.sample.service.impl	AOP所切的服务的包名，即，我们的业务部分
包名后面的”..“	表示当前包及子包
第二个”*“	表示类名，*即所有类。此处可以自定义，下文有举例
.*(..)	表示任何方法名，括号表示参数，两个点表示任何参数类型