#!/bin/bash
# 打包
mvn clean package -DskipTests
# docker build
docker build -t fengwenyi/demo-spring-boot-docker .
# docker tag
docker tag fengwenyi/demo-spring-boot-docker fengwenyi/demo-spring-boot-docker
# 推送到docker镜像仓库，默认docker仓库
docker push fengwenyi/demo-spring-boot-docker