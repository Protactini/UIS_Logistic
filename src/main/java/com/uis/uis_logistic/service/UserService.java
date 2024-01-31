package com.uis.uis_logistic.service;

import com.uis.uis_logistic.dto.LoginDto;
import com.uis.uis_logistic.dto.RegisterDto;
import com.uis.uis_logistic.model.RoleEntity;
import com.uis.uis_logistic.model.UserEntity;
import com.uis.uis_logistic.repository.RoleRepository;
import com.uis.uis_logistic.repository.UserRepository;
import com.uis.uis_logistic.security.JWTGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;
    private JWTGenerator jwtGenerator;
    private AuthenticationManager authenticationManager;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository,
                       PasswordEncoder passwordEncoder, JWTGenerator jwtGenerator,
                       AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.jwtGenerator = jwtGenerator;
        this.authenticationManager = authenticationManager;
    }

    public void addNewUser(RegisterDto registerDto){
        Date currentDate = new Date();

        RoleEntity roles = roleRepository.findByName("USER").get();

        UserEntity user = new UserEntity().builder()
                .username(registerDto.getUsername())
                .password(passwordEncoder.encode((registerDto.getPassword())))
//                .createdAt((Timestamp) currentDate)
                .roles(Collections.singletonList(roles))
                .build();

        userRepository.save(user);
    }

    public boolean userExistByUsername (String usrname){
        return userRepository.existsByUsername(usrname);
    }


    public String JWTTokenGenerator(LoginDto loginDto) throws Exception {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getUsername(),
                        loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return jwtGenerator.generateToken(authentication);
    }

}
