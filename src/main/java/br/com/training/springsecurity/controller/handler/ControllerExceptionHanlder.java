package br.com.training.springsecurity.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHanlder {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<StandarError> throwException(RuntimeException e, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(StandarError.valueOf(e,HttpStatus.BAD_REQUEST));
    }
}
