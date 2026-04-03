package com.dinesh.linkpay.user.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dinesh.linkpay.user.model.User;

public interface UserRepository extends JpaRepository<User, UUID> {
    // Add as needed
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
