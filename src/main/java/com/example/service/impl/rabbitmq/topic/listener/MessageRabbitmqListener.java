package com.example.service.impl.rabbitmq.topic.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Component
public class MessageRabbitmqListener {

    @RabbitListener(queues = "topic_queue")
    public void receive(String id){
        System.out.println("已完成短信处理业务（rabbitmq direct 111）id：" + id);
    }

    @RabbitListener(queues = "topic_queue2")
    public void receive2(String id){
        System.out.println("已完成短信处理业务（rabbitmq direct 222）id：" + id);
    }

}
