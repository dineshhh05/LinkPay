package com.dinesh.linkpay.user.exception;

public class DuplicateUsernameException extends IllegalArgumentException {

    public DuplicateUsernameException (String username){
        super("Username: '" + username + "' already exists");
    }
}