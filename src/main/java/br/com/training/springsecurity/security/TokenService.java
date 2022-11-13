package br.com.training.springsecurity.security;

import br.com.training.springsecurity.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class TokenService {

    @Value("${secutiry.jwt.expiration}")
    private String expiration;

    @Value("${secutiry.jwt.secret}")
    private String secret;

    public String getToken(Authentication authenticate) {
        User principal = (User) authenticate.getPrincipal();
        return Jwts.builder()
                .setIssuer("Token de autenticação")
                .setSubject(principal.getId().toString())
                .setIssuedAt(Date.valueOf(LocalDate.now()))
                .setExpiration(Date.valueOf(LocalDate.now().plusDays(1L)))
                .signWith(SignatureAlgorithm.HS256,secret)
                .compact();

    }

    public Boolean isTokenValid(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token);
            return Boolean.TRUE;
        } catch (RuntimeException e){
            return Boolean.FALSE;
        }
    }

    public Long getIdUser(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());
    }
}
