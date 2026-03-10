package com.vini.auth_api.controller;

import com.vini.auth_api.controller.definition.AuthenticationControllerDef;
import com.vini.auth_api.dto.auth.LoginResponseDTO;
import com.vini.auth_api.dto.auth.RegisterUserDTO;
import com.vini.auth_api.dto.auth.UserLoginDTO;
import com.vini.auth_api.model.User;
import com.vini.auth_api.service.AuthenticationService;
import com.vini.auth_api.service.JwtService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController implements AuthenticationControllerDef {

    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    @Override
    @PostMapping("/signup")
    public ResponseEntity<@NonNull User> register(@RequestBody RegisterUserDTO registerUserDTO) {
        User registeredUser = authenticationService.signUp(registerUserDTO);

        return ResponseEntity.ok(registeredUser);
    }

    @Override
    @PostMapping("/login")
    public ResponseEntity<@NonNull LoginResponseDTO> login(@RequestBody UserLoginDTO userLoginDTO) {
        User authenticatedUser = authenticationService.authenticate(userLoginDTO);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
        loginResponseDTO.setToken(jwtToken);
        loginResponseDTO.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponseDTO);
    }

}
