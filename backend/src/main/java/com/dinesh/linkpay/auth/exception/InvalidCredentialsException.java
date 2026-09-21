package com.dinesh.linkpay.auth.exception;

public class InvalidCredentialsException extends IllegalArgumentException {
    public InvalidCredentialsException(){
        super("Inavlid credentials");
    }
}
 