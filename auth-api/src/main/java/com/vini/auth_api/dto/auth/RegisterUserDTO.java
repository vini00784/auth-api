package com.vini.auth_api.dto.auth;

import lombok.Data;

@Data
public class RegisterUserDTO {

    private String email;

    private String password;

    private String fullName;

}
