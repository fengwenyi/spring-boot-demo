FROM openjdk:17-jdk-alpine
MAINTAINER Erwin Feng xfsy_2015@163.com

ENV active = 'dev'

COPY target/demo-spring-boot-docker-*.jar /app.jar
ENTRYPOINT ["sh", "-c", "java -jar app.jar --spring.profiles.active=$active"]