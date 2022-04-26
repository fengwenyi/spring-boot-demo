FROM openjdk:8-jdk-alpine
MAINTAINER Erwin Feng xfsy_2015@163.com

ENV VERSION=1.0.0

COPY target/demo-spring-boot-docker-*.jar /app.jar
ENTRYPOINT ["sh", "-c", "java -jar app.jar"]