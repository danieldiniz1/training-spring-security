package br.com.training.springsecurity.controller.dto;

public class TokenDTO {

    private String token;
    private String type;

    public TokenDTO(String token, String type) {
        this.token = token;
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public String getType() {
        return type;
    }

    public static Object valueOf(String token, String type) {
        return new TokenDTO(token,type);
    }
}
