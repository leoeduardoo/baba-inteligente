package com.grupo03.kafka.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ErrorDetail {
    private int status;
    private String detail;
    private String timeStamp;
    private String exceptionClass;
}