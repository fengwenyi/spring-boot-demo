

## @Cacheable

### 用法一

`@CacheConfig(cacheNames = {"name1", "name2})`

会用到哪些缓存名称

`@Cacheable(key = "#id")`

这两个配合一起用


### 用法二

`@Cacheable(value = "goods", key = "#id")`

value：缓存的名字，key：缓存的key