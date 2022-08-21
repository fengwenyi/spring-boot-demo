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

## 延迟队列

首先来看一个错：

> channel error； protocol method: #method＜channel.close＞(reply-code=404, reply-text=NOT_FOUND - no

原因是，延迟队列是 RabbitMQ 的一个插件，默认没有安装，需要安装。

相关链接：

- RabbitMQ 插件：https://www.rabbitmq.com/community-plugins.html
- 延迟插件：https://github.com/rabbitmq/rabbitmq-delayed-message-exchange/releases

安装插件：

- 1.下载延迟队列插件
- 2.将插件复制到 RabbitMQ 的 `/plugins` 目录下。拷贝方法：`docker cp rabbitmq_delayed_message_exchange-3.10.2.ez containerId:/plugins`
- 3.执行，在 `/plugins` 目录下执行：`rabbitmq-plugins enable rabbitmq_delayed_message_exchange`
- 4.重启 RabbitMQ

配置：

```java
    /**
     * 延时队列交换机
     * 注意这里的交换机类型：CustomExchange
     *
     * @return
     */
    @Bean
    public CustomExchange delayExchange() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-delayed-type", "direct");
        //属性参数 交换机名称 交换机类型 是否持久化 是否自动删除 配置参数
        return new CustomExchange("delay_exchange", "x-delayed-message", true, false, args);
    }

    /**
     * 延时队列
     *
     * @return
     */
    @Bean
    public Queue delayQueue() {
        //属性参数 队列名称 是否持久化
        return new Queue("delay_queue", true);
    }

    /**
     * 给延时队列绑定交换机
     *
     * @return
     */
    @Bean
    public Binding cfgDelayBinding() {
        return BindingBuilder.bind(delayQueue()).to(delayExchange()).with("delay_key").noargs();
    }
```

发送

```java
//第一个参数是前面RabbitMqConfig的交换机名称 第二个参数的路由名称 第三个参数是传递的参数 第四个参数是配置属性
        this.rabbitTemplate.convertAndSend(
                "delay_exchange",
                "delay_key",
                order.toJson(),
                message -> {
                    //配置消息的过期时间
                    message.getMessageProperties().setDelay(time);
                    return message;
                }
        );
```

接收消息：

```java
@RabbitListener(queues = "delay_queue")
public void receiveMsgByDelayQueue(String msg) throws IOException {
    log.info("==>receive msg: [{}]", Order.to(msg));
}
```

测试：

```http request
### 发送延迟队列消息
GET http://localhost:8080/sendDelayMsg/10000/iPhone13
```
