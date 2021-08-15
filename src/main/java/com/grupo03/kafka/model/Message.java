package com.grupo03.kafka.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private String sender;
    private String type;
    private String value;
    private String timestamp;

    @Override
    public String toString() {
        return "Message {" +
                " sender='" + sender + '\'' +
                " type='" + type + '\'' +
                ", value='" + value + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }

}