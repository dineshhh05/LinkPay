package com.dinesh.linkpay.user.dto;

import java.time.Instant;
import java.util.UUID;

import com.dinesh.linkpay.user.model.User;

public class UserResponse {
    

    private UUID userId;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private Instant createdAt;

    public UserResponse(
        UUID userId,
        String username,
        String email,
        String firstName,
        String lastName,
        Instant createdAt
        // List<Link> links
    ){
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.createdAt = createdAt;
    }

    public static UserResponse from(User user){
        return new UserResponse(
            user.getId(),
            user.getUsername(),
            user.getEmail(),
            user.getFirstName(),
            user.getLastName(),
            user.getCreatedAt()
        );
    }

    // Getters only as its read only 
    public UUID getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }



}
