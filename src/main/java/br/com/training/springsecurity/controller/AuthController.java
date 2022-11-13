package br.com.training.springsecurity.controller;

import br.com.training.springsecurity.controller.dto.TokenDTO;
import br.com.training.springsecurity.controller.form.LoginForm;
import br.com.training.springsecurity.security.TokenService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/token")
    public ResponseEntity autenticar(@RequestBody @Valid LoginForm form){
        return ResponseEntity.status(HttpStatus.OK).body(TokenDTO.valueOf(validateAndGetToken(form),"Bearer"));
    }

    private String validateAndGetToken(LoginForm form) {
        UsernamePasswordAuthenticationToken dadosLogin = form.converter();
        Authentication authenticate = authenticationManager.authenticate(dadosLogin);
        LOGGER.info(tokenService.getToken(authenticate));
        return tokenService.getToken(authenticate);
    }
}
