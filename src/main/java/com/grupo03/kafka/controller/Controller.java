package com.grupo03.kafka.controller;

import com.grupo03.kafka.constants.IKafkaConstants;
import com.grupo03.kafka.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class Controller {

    @Autowired
    private KafkaTemplate<String, Message> kafkaTemplate;

    @PostMapping(value = "/temperature", consumes = "application/json", produces = "application/json")
    public void sendTemperature(@RequestBody Message message) {
        try {
            // sends message to kafka topic queue
            kafkaTemplate.send(IKafkaConstants.KAFKA_TOPIC, message).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    @MessageMapping("/sendTemperature")
    @SendTo("/TEMPERATURE_TOPIC/TEMPERATURE_GROUP")
    public Message broadcastGroupMessage(@Payload Message message) {
        // sending this message to all the subscribers
        return message;
    }

}