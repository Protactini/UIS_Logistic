package com.uis.uis_logistic.controller;
import com.uis.uis_logistic.dto.LoginRequest;
import com.uis.uis_logistic.service.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

@RestController
public class AuthenticationController {

//    private final AuthenticationManager authenticationManager;
//    private final JwtUtil jwtTokenUtil;
//
//    public AuthenticationController(AuthenticationManager authenticationManager, JwtUtil jwtTokenUtil) {
//        this.authenticationManager = authenticationManager;
//        this.jwtTokenUtil = jwtTokenUtil;
//    }
//
//    @PostMapping("/authenticate")
//    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest authenticationRequest) {
//        try {
//            // Authenticate the user
//            Authentication authenticate = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            authenticationRequest.getUsername(),
//                            authenticationRequest.getPassword()
//                    )
//            );
//
//            // If authentication was successful, generate a JWT token
//            final String jwt = jwtTokenUtil.generateToken(authenticationRequest.getUsername());
//
//            return ResponseEntity.ok(new AuthenticationResponse(jwt));
//        } catch (AuthenticationException e) {
//            return ResponseEntity.badRequest().body("Invalid credentials");
//        }
//    }
}

