package com.dinesh.linkpay.user.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dinesh.linkpay.user.dto.UserCreateRequest;
import com.dinesh.linkpay.user.exception.DuplicateEmailException;
import com.dinesh.linkpay.user.exception.DuplicateUsernameException;
import com.dinesh.linkpay.user.exception.UserNotFoundException;
import com.dinesh.linkpay.user.model.User;
import com.dinesh.linkpay.user.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
    
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Transactional
    public User createUser(UserCreateRequest req){

        validateParams(req);

        User newUser = new User(req.getUsername(), req.getEmail(), req.getFirstName(), req.getLastName());

        return userRepository.save(newUser);
    }

    public User getUserById(UUID id){
        return userRepository.findById(id)
            .orElseThrow(() -> new UserNotFoundException(id));
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @Transactional
    public void deleteUserById(UUID id){

        User user = userRepository.findById(id)
            .orElseThrow(() -> new UserNotFoundException(id));

        userRepository.delete(user);
    }



    // Helper functions

    private void validateParams(UserCreateRequest user){

        if(userRepository.existsByUsername(user.getUsername())){
            throw new DuplicateUsernameException(user.getUsername());
        }

        if(userRepository.existsByEmail(user.getEmail())){
            throw new DuplicateEmailException(user.getEmail());
        }
    }
}
