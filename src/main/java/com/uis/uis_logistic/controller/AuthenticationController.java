package com.uis.uis_logistic.controller;
import com.uis.uis_logistic.dto.AuthResponseDTO;
import com.uis.uis_logistic.dto.LoginDto;
import com.uis.uis_logistic.dto.RegisterDto;
import com.uis.uis_logistic.model.RoleEntity;
import com.uis.uis_logistic.model.UserEntity;
import com.uis.uis_logistic.repository.RoleRepository;
import com.uis.uis_logistic.repository.UserRepository;
import com.uis.uis_logistic.security.JWTGenerator;
import com.uis.uis_logistic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private AuthenticationManager authenticationManager;
    private UserService userService;

    @Autowired
    public void AuthController(AuthenticationManager authenticationManager, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    @PostMapping("login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDto loginDto) throws Exception {

        String token = userService.JWTTokenGenerator(loginDto);

        return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
    }

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        if (userService.userExistByUsername(registerDto.getUsername())) {
            return new ResponseEntity<>("Username is taken!", HttpStatus.BAD_REQUEST);
        }

        userService.addNewUser(registerDto);

        return new ResponseEntity<>("User registered success!", HttpStatus.OK);
    }
}

