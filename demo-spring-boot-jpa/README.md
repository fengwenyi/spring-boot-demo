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