# Spring Boot ElasticSearch

### @Document 注解

```java
public @interface Document {
  
String indexName(); //索引库的名称，个人建议以项目的名称命名
  
String type() default ""; //类型，个人建议以实体的名称命名
  
short shards() default 5; //默认分区数
  
short replicas() default 1; //每个分区默认的备份数
  
String refreshInterval() default "1s"; //刷新间隔
  
String indexStoreType() default "fs"; //索引文件存储类型
}
```

### @Field注解

```java
public @interface Field {
  
FieldType type() default FieldType.Auto; //自动检测属性的类型，可以根据实际情况自己设置
  
FieldIndex index() default FieldIndex.analyzed; //默认情况下分词，一般默认分词就好，除非这个字段你确定查询时不会用到
  
DateFormat format() default DateFormat.none; //时间类型的格式化
  
String pattern() default "";
  
boolean store() default false; //默认情况下不存储原文
  
String searchAnalyzer() default ""; //指定字段搜索时使用的分词器
  
String indexAnalyzer() default ""; //指定字段建立索引时指定的分词器
  
String[] ignoreFields() default {}; //如果某个字段需要被忽略
  
boolean includeInParent() default false;
}
```

### FieldType类型

```java
public enum FieldType {
    Text,
    Integer,
    Long,
    Date,
    Float,
    Double,
    Boolean,
    Object,
    Auto,
    Nested,
    Ip,
    Attachment,
    Keyword
}
```

### 其他说明

Keyword类型：用于索引结构化内容（如电子邮件地址，主机名，状态码，邮政编码等）的字段。他们通常用于过滤、排序、聚合。关键字字段只能根据期确切的值进行搜索

Ip类型：ip字段可以索引和存储IPV4和IPv6地址

Nested类型：嵌套类型是对象数据类型的一个专门的版本，他允许对象数组以一种彼此独立查询的方式进行索引


Text类型：索引全文字段，如电子邮件正文的描述或者产品描述。这些字段被分析器将字符串转换为单个术语列表。分析过程允许es在每个的全文域中搜索单个单词。文本字段不用于排序，也很少用于聚合<br>Object类型：Json文档本质上是分层的，文档可能包含内部对象，而这些对象又可能包含内部对象本身。

