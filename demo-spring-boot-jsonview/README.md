# Spring Boot JsonView

## 返回null和空集

在项目开发中我们有时候会需要过滤字段值为null的字段或者为空集的字段，如果一个字段的值是null或者是空list或者set等空集，我们就不返回该字段。这怎么来操作呢？

第一种我们可以在返回的对象类上加上 `@JsonInclude(JsonInclude.Include.NON_EMPTY)` 注解

全局配置，所有的返回都适用

```yaml
spring:
  jackson:
    default-property-inclusion: non_empty
```

上面两种方法中都有non_empty，这个是指不返回null和空集，如果只需要过滤null的话改为non_null即可

## 报错

```
Failed to bind properties under 'spring.jackson.default-property-inclusion' to com.fasterxml.jackson.annotation.JsonInclude$Include:

    Property: spring.jackson.default-property-inclusion
    Value: DEFAULT_VIEW_INCLUSION
    Origin: class path resource [application.yml] - 7:33
    Reason: failed to convert java.lang.String to com.fasterxml.jackson.annotation.JsonInclude$Include (caused by java.lang.IllegalArgumentException: No enum constant com.fasterxml.jackson.annotation.JsonInclude.Include.DEFAULT_VIEW_INCLUSION)

Action:

Update your application's configuration. The following values are valid:

    ALWAYS
    CUSTOM
    NON_ABSENT
    NON_DEFAULT
    NON_EMPTY
    NON_NULL
    USE_DEFAULTS
```

## 解决没有加 `@JsonView` 不返回的问题

```yaml
spring:
  jackson:
    mapper:
      DEFAULT_VIEW_INCLUSION: true
```

## API List

GET http://localhost:8080/users

```json
{
  "code":0,
  "message":"Success",
  "success":true,
  "body":[
    {
      "id":1,
      "username":"u1"
    },
    {
      "id":2,
      "username":"u2"
    },
    {
      "id":3,
      "username":"u3"
    }
  ]
}
```

## API Detail

GET http://localhost:8080/users/2

```json
{
    "code":0,
    "message":"Success",
    "success":true,
    "body":{
        "id":2,
        "username":"u2",
        "age":22
    }
}
```
