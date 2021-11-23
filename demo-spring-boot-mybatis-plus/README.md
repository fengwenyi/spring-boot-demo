# Spring Boot and MyBatis Plus

## 排序

- 单条件

- 多条件

- 数据库字段

```java
public class UserService {

    public void orderBy1() {
        LambdaQueryWrapper<UserEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(UserEntity::getId);
    }

    public void orderBy2() {
        LambdaQueryWrapper<UserEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Arrays.asList(UserEntity::getUsername, UserEntity::getPassword));
    }

    public void orderBy3() {
        QueryWrapper<UserEntity> qw = new QueryWrapper<>();
        qw.orderByDesc(Arrays.asList("username", "password"));
    }

}
```

