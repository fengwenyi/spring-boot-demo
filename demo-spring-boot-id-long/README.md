# Spring Boot 项目 ID 字段为 Long 解决办法

## 后端解决

思路：将 Long 转换成 String

### 直接返回 String


### 返回 Long，全局转换成 String

问题：全局转换，所有 Long 类型的字段都会被转换成 String


## 前端解决

### Ajax

### axios