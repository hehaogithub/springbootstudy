package com.bootstudy.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class cosumer2 {
    /**
     * 定义此消费者接收topics = "demo"的消息，与controller中的topic对应上即可
     * @param record 变量代表消息本身，可以通过ConsumerRecord<?,?>类型的record变量来打印接收的消息的各种信息
     */
    @KafkaListener(topics = "topic1")
    public void listen (ConsumerRecord<?, ?> record){
        System.out.println("消费者2：");
        System.out.printf("topic is %s, offset is %d, value is %s \n", record.topic(), record.offset(), record.value());
    }

}
