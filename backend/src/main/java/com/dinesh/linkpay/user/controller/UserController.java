package com.dinesh.linkpay.user.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dinesh.linkpay.user.dto.UserCreateRequest;
import com.dinesh.linkpay.user.dto.UserResponse;
import com.dinesh.linkpay.user.model.User;
import com.dinesh.linkpay.user.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    // ---------- POST METHODS ----------

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserCreateRequest req){
        
        User newUser = userService.createUser(req);

        UserResponse response = UserResponse.from(newUser);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(response);
    }

    // ---------- GET METHODS ----------

    @GetMapping("/me")
    public ResponseEntity<UserResponse> getLoggedInUser(Authentication authentication){

        User user = (User) authentication.getPrincipal();
        return ResponseEntity.ok(UserResponse.from(user));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable("userId") UUID id){
        
        User fetchedUser = userService.getUserById(id);

        UserResponse response = UserResponse.from(fetchedUser);

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(response);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers(){

        List<User> listOfUsers = userService.getAllUsers();

        List<UserResponse> listOfResponse = new ArrayList<>();

        for(User user : listOfUsers){
            listOfResponse.add(UserResponse.from(user));
        }

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(listOfResponse);
    }

    // ---------- DELETE METHODS ----------
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUserById(@PathVariable("userId") UUID id){

        userService.deleteUserById(id);

        return ResponseEntity.noContent().build();
    }


}
