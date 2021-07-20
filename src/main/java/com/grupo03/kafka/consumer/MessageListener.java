package com.grupo03.kafka.consumer;

import com.grupo03.kafka.constants.IKafkaConstants;
import com.grupo03.kafka.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @Autowired
    SimpMessagingTemplate template;

    @KafkaListener(topics = IKafkaConstants.KAFKA_TOPIC, groupId = IKafkaConstants.GROUP_ID)
    public void listen(Message message) {
        template.convertAndSend("/TEMPERATURE_TOPIC/TEMPERATURE_GROUP", message);
        System.out.println("message received: \n" + message.toString());
    }

}