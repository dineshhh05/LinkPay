package com.dinesh.linkpay.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dinesh.linkpay.auth.dto.AuthResponse;
import com.dinesh.linkpay.auth.dto.LoginRequest;
import com.dinesh.linkpay.auth.service.AuthService;
import com.dinesh.linkpay.user.dto.UserCreateRequest;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/auth")
public class AuthController {
    
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    // ---------- POST METHODS ----------
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> registerUser(@Valid @RequestBody UserCreateRequest req) {
        
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(authService.registerUser(req));

    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> loginUser(@Valid @RequestBody LoginRequest req){

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(authService.loginUser(req));
    }








}
