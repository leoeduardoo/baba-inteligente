package com.grupo03.kafka.model;

import lombok.Getter;

@Getter
public enum AllergyType {
    REMEDY("Remedy"), FOOD("Food"), OTHER("Other");

    private final String type;

    AllergyType(final String type) {
        this.type = type;
    }

}
