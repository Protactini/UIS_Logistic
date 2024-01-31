package com.uis.uis_logistic.controller;

import com.uis.uis_logistic.dto.AuthResponseDTO;
import com.uis.uis_logistic.dto.LoginDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @GetMapping("allitems")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDto loginDto) throws Exception {

        String token = userService.JWTTokenGenerator(loginDto);

        return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
    }



}
