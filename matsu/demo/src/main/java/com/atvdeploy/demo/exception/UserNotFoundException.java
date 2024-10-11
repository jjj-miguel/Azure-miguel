package com.atvdeploy.demo.exception;

public class UserNotFoundException extends Exception {
    
    public UserNotFoundException(String message){
        super(message);
    }
}
