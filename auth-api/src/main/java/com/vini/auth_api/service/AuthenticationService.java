package com.vini.auth_api.service;

import com.vini.auth_api.dto.auth.RegisterUserDTO;
import com.vini.auth_api.dto.auth.UserLoginDTO;
import com.vini.auth_api.model.User;
import com.vini.auth_api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public User signUp(RegisterUserDTO registerUserDTO) {
        User user = new User();
        user.setFullName(registerUserDTO.getFullName());
        user.setPassword(passwordEncoder.encode(registerUserDTO.getPassword()));
        user.setEmail(registerUserDTO.getEmail());

        return userRepository.save(user);
    }

    public User authenticate(UserLoginDTO userLoginDTO) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userLoginDTO.getEmail(),
                        userLoginDTO.getPassword()
                )
        );

        return userRepository.findByEmail(userLoginDTO.getEmail()).orElseThrow();
    }

}
