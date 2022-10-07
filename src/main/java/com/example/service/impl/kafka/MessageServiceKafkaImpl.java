package com.example.service.impl.kafka;

import com.example.service.MessageService;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceKafkaImpl implements MessageService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendMessage(String id) {
        System.out.println("带发送短信的订单已纳入处理队列（kafka、topic）id：" + id);
        kafkaTemplate.send("springboottest", id);
    }

    @Override
    public String doMessage() {
        return null;
    }
}
