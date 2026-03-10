package com.vini.auth_api.controller.definition;

import com.vini.auth_api.dto.auth.LoginResponseDTO;
import com.vini.auth_api.dto.auth.RegisterUserDTO;
import com.vini.auth_api.dto.auth.UserLoginDTO;
import com.vini.auth_api.model.User;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthenticationControllerDef {

    ResponseEntity<@NonNull User> register(@RequestBody RegisterUserDTO registerUserDTO);

    ResponseEntity<@NonNull LoginResponseDTO> login(@RequestBody UserLoginDTO userLoginDTO);

}
