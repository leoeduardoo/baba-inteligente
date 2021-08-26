package com.grupo03.kafka.model.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.grupo03.kafka.model.AllergyType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AllergyRequest {

    @JsonProperty("type")
    private AllergyType type;

    @JsonProperty("description")
    private String description;

}