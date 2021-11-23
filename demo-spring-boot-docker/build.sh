#!/bin/bash
# 定义版本
version=1.0.0
# 打包
mvn clean package -DskipTests
# docker build
docker build -t fengwenyi/demo-spring-boot-docker:$version .
# docker tag
docker tag fengwenyi/demo-spring-boot-docker:$version fengwenyi/demo-spring-boot-docker:$version
# 推送到docker镜像仓库，默认docker仓库
docker push fengwenyi/demo-spring-boot-docker:$version
# git tag
git tag -a $version -m "v$version"
# git 推送版本
git push origin $version