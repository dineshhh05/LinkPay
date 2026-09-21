package com.dinesh.linkpay.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dinesh.linkpay.auth.dto.AuthResponse;
import com.dinesh.linkpay.auth.dto.LoginRequest;
import com.dinesh.linkpay.auth.exception.InvalidCredentialsException;
import com.dinesh.linkpay.user.dto.UserCreateRequest;
import com.dinesh.linkpay.user.dto.UserResponse;
import com.dinesh.linkpay.user.model.User;
import com.dinesh.linkpay.user.repository.UserRepository;
import com.dinesh.linkpay.user.service.UserService;

import jakarta.transaction.Transactional;

@Service
public class AuthService {
    
    private final UserRepository userRepository;
    private final UserService userService;
    private final JwtService jwtService;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public AuthService(UserRepository userRepository, UserService userService, JwtService jwtService){
        this.userRepository = userRepository;
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @Transactional
    public AuthResponse registerUser(UserCreateRequest req){
        
        User user = userService.createUser(req);

        return new AuthResponse(jwtService.generateToken(user), UserResponse.from(user));
    }

    public AuthResponse loginUser(LoginRequest req){
        
        User user = userRepository.findByUsername(req.getUsername())
            .orElseThrow(() -> new InvalidCredentialsException());

        if(!passwordEncoder.matches(req.getPassword(), user.getHashedPassword())){
            throw new InvalidCredentialsException();
        }

        return new AuthResponse(jwtService.generateToken(user), UserResponse.from(user));
    }



}
