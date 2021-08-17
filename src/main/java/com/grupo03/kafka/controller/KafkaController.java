package com.grupo03.kafka.controller;

import com.grupo03.kafka.constants.IKafkaConstants;
import com.grupo03.kafka.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;

@RestController
public class KafkaController {

    @Autowired
    private KafkaTemplate<String, Message> kafkaTemplate;

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(value = "/temperature", consumes = "application/json", produces = "application/json")
    public void sendTemperature(@RequestBody Message message) {
        try {
            // sends temperature to kafka topic queue
            message.setTimestamp(LocalDateTime.now().toString());
            kafkaTemplate.send(IKafkaConstants.KAFKA_TEMPERATURE_TOPIC, message).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(value = "/crying", consumes = "application/json", produces = "application/json")
    public void sendCrying(@RequestBody Message message) {
        try {
            // sends crying to kafka topic queue
            message.setTimestamp(LocalDateTime.now().toString());
            kafkaTemplate.send(IKafkaConstants.KAFKA_CRYING_TOPIC, message).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @MessageMapping("/sendTemperature")
    @SendTo("/TEMPERATURE_TOPIC/TEMPERATURE_GROUP")
    public Message broadcastTemperatureGroupMessage(@Payload Message message) {
        // sends this message to all the subscribers
        return message;
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @MessageMapping("/sendCrying")
    @SendTo("/CRYING_TOPIC/CRYING_GROUP")
    public Message broadcastCryingGroupMessage(@Payload Message message) {
        // sends this message to all the subscribers
        return message;
    }

}