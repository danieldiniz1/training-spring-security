package br.com.training.springsecurity.controller.handler;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class StandarError {

    private String message;
    private Integer errorCod;
    private LocalDateTime timeStamp;

    public StandarError(String message, Integer errorCod, LocalDateTime timeStamp) {
        this.message = message;
        this.errorCod = errorCod;
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public Integer getErrorCod() {
        return errorCod;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public static StandarError valueOf(Exception e, HttpStatus status){
        return new StandarError(e.getMessage(), status.value(), LocalDateTime.now());
    }
}
