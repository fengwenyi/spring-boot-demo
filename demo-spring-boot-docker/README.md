# Spring Boot and Docker

## links

[「Spring Boot 新特性」一键构建Docker镜像](https://mp.weixin.qq.com/s?__biz=MjM5MzEwODY4Mw==&mid=2257485430&idx=1&sn=bc6865168c787d69b041a3867fea6082&chksm=a5e6d9d2929150c4aef67c6427b07a6768d5a9142dcb835c92e08e7f8b99ab781e3eee154444&token=711727790&lang=zh_CN#rd)


## DockerFiler

### jdk 版本

jdk 8

```shell
FROM openjdk:8-jdk-alpine
```

jdk 17

```shell
FROM openjdk:17-jdk-alpine
```

### 支持切换环境

```shell
ENV active = 'dev'

ENTRYPOINT ["sh", "-c", "java -jar app.jar --spring.profiles.active=$active"]
```