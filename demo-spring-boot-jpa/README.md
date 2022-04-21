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