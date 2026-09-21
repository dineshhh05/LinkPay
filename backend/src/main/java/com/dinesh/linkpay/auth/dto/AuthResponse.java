package com.dinesh.linkpay.auth.dto;

import com.dinesh.linkpay.user.dto.UserResponse;

public class AuthResponse {
    
    private String token;
    private UserResponse userResponse;
    
    public AuthResponse() {}

    public AuthResponse(String token, UserResponse userResponse) {
        this.token = token;
        this.userResponse = userResponse;
    }
    
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public UserResponse getUserResponse() {
        return userResponse;
    }
    public void setUserResponse(UserResponse userResponse) {
        this.userResponse = userResponse;
    }


}
