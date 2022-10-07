package com.example.service.impl.kafka.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @KafkaListener(topics = "springboottest")
    public void onMessage(ConsumerRecord<String, String> record){
        System.out.println("已完成短信接收业务（kafka）id " + record.value());
    }
}
