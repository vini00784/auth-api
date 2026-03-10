package com.vini.auth_api.dto.auth;

import lombok.Data;

@Data
public class LoginResponseDTO {

    private String token;

    private long expiresIn;

}
