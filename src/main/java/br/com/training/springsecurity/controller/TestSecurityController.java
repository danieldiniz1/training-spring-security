package br.com.training.springsecurity.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
public class TestSecurityController {

    private static final Logger LOGGER = LogManager.getLogger();

    @GetMapping
    public ResponseEntity getTest(){
        LOGGER.info("O processo de autenticação funcionou");
        return ResponseEntity.ok().build();
    }
}
