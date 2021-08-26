package com.grupo03.kafka.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.text.SimpleDateFormat;
import java.util.Date;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(NotFoundException e) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setStatus(HttpStatus.NOT_FOUND.value());
        errorDetail.setTimeStamp(sdf.format(new Date()));
        errorDetail.setDetail(e.getMessage());
        errorDetail.setExceptionClass(e.getClass().getName());

        return new ResponseEntity<>(errorDetail, HttpStatus.NOT_FOUND);
    }

}