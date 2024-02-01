package com.uis.uis_logistic.controller;


import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("info")
    public String currentUserName(Authentication authentication){
        return authentication.getName();
    }
}
