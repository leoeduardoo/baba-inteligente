package com.grupo03.kafka.exception;

public class NotFoundException extends Exception {

    public NotFoundException(String resource) {
        super(resource + " not found with given parameter(s).");
    }

}