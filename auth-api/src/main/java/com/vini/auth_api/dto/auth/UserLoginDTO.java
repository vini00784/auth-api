package com.vini.auth_api.dto.auth;

import lombok.Data;

@Data
public class UserLoginDTO {

    private String email;

    private String password;

}
