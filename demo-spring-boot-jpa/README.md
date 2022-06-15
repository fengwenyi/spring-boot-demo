# Spring Data JPA

## JPA Auditing


开启
```
@EnableJpaAuditing
```


实体类
```
@Entity
@EntityListeners(AuditingEntityListener.class)
```


创建时间
```
@CreatedDate
```

更新时间
```
@LastModifiedDate
```

## JPA MySQL Json

依赖：

```xml
<dependency>
    <groupId>com.vladmihalcea</groupId>
    <artifactId>hibernate-types-52</artifactId>
    <version>2.16.1</version>
</dependency>
```

实体类：

```java
@Entity
@Table(name = "t_event")
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class Event {

    // ....

    @Type(type = "json")
    @Column(name = "location", columnDefinition = "json")
    private Location location;

    @Type(type = "json")
    @Column(name = "locations", columnDefinition = "json")
    private List<Location> locations;

    // ....
}
```

## ExampleMatcher.GenericPropertyMatchers 查询策略

- ExampleMatcher.GenericPropertyMatchers.ignoreCase(): 忽略大小写 lower(userentity0_.username)=?
- ExampleMatcher.GenericPropertyMatchers.contains() ： 包含，类似 %key%
- ExampleMatcher.GenericPropertyMatchers.startsWith() : 开头，类似 key%
- ExampleMatcher.GenericPropertyMatchers.endsWith()
- withIgnorePaths("password") ：忽略字段，不加入查询条件

## 疑问

1. findOne 方法如果有多条，会不会报错

经过测试，会报错！

3. Sort 排序字段 是数据库字段 还是实体类属性

经过测试，必须谢属性，写数据库字段会报错！