package com.example.service.impl.rabbitmq.direct.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Component
public class MessageRabbitmqListener {

    @RabbitListener(queues = "direct_queue")
    public void receive(String id){
        System.out.println("已完成短信处理业务（rabbitmq direct 1）id：" + id);
    }

}
