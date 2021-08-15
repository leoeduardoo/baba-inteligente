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

    @KafkaListener(topics = IKafkaConstants.KAFKA_TEMPERATURE_TOPIC, groupId = IKafkaConstants.GROUP_ID)
    public void listenTemperature(Message message) {
        template.convertAndSend("/TEMPERATURE_TOPIC/TEMPERATURE_GROUP", message);
        System.out.println("Temperature received: \n" + message.toString());
    }

    @KafkaListener(topics = IKafkaConstants.KAFKA_CRYING_TOPIC, groupId = IKafkaConstants.GROUP_ID)
    public void listenCrying(Message message) {
        template.convertAndSend("/CRYING_TOPIC/CRYING_GROUP", message);
        System.out.println("Crying received: \n" + message.toString());
    }

}