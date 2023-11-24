# Spring Boot and RabbitMQ

延迟队列：https://blog.fengwenyi.com/blog/springboot_rabbitmq_delay_queue.html

多个消费者

```java
@RabbitListener(bindings = @QueueBinding(
            // value = @Queue(), //切记： 此处无需设置队列名称，否在得话，多个消费者只有一个消费者能消费数据。其它消费者无法消费数据。随机生成名字
            value = @Queue("queue_consumer01"), 
            exchange = @Exchange(value = RabbitMQConfig.FANOUT_EXCHANGE_DEMO)
    ))
    public void consumer01(String msg) {
        log.info("[{}], [{}], [{}]", "consumer01", LocalDateTime.now(), msg);
    }
```