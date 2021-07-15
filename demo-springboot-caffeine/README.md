
## 配置

### 代码

```java
@Configuration
public class BeanConfiguration {

    @Bean
    public CacheManager caffeineCacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setCaffeine(
                Caffeine.newBuilder()
                        .expireAfterWrite(30, TimeUnit.SECONDS));
        return cacheManager;
    }

}
```

### 配置文件

```yaml
spring:
  cache:
    type: caffeine
    cache-names: goods
    caffeine:
      spec: maximumSize=500, expireAfterAccess=30s
```