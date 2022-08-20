# Spring Boot and RabbitMQ

依赖：

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-amqp</artifactId>
</dependency>
```

配置

```yaml
spring:
  rabbitmq:
    host: localhost
    port: 5672
    username: admin
    password: admin
    virtual-host: my_vhost
```

配置

```java
@Configuration
public class RabbitMQConfig {

    // item 交换机
    public static final String ITEM_TOPIC_EXCHANGE = "item_topic_exchange";

    // item 队列
    public static final String ITEM_QUEUE = "item_queue";

    // 声明交换机
    @Bean
    public Exchange itemTopicExchange() {
        return ExchangeBuilder.topicExchange(ITEM_TOPIC_EXCHANGE).durable(true).build();
    }

    // 声明队列
    @Bean
    public Queue itemQueue() {
        return QueueBuilder.durable(ITEM_QUEUE).build();
    }

    // 绑定队列和交换机
    @Bean
    public Binding itemQueueExchange(@Qualifier("itemQueue") Queue queue,
                                     @Qualifier("itemTopicExchange") Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("item.#").noargs();
    }


}
```

发送

```java
@RestController
public class SendMsgController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/sendMsg")
    public String sendMsg(String key, String msg) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.ITEM_TOPIC_EXCHANGE, key, msg);
        return "发送成功";
    }
}
```

接收

```java
@Component
@Slf4j
public class MyListener {

    @RabbitListener(queues = RabbitMQConfig.ITEM_QUEUE)
    public void receiveMsg(String msg) {
        log.info("receive msg: [{}]", msg);
    }

}
```

测试

```http request
### 发送消息
GET http://localhost:8080/sendMsg?key=item.test&msg=Hello
```
