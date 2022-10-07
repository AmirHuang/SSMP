package com.example.service.impl.rabbitmq.topic;

import com.example.service.MessageService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//@Service
public class MessageServiceRabbitmqImpl implements MessageService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public void sendMessage(String id) {
        System.out.println("带发送短信的订单已纳入处理队列（rabbitmq、topic）id：" + id);
        amqpTemplate.convertAndSend("topicExchange", "topic.order.id", id);
    }

    @Override
    public String doMessage() {
        return null;
    }
}
