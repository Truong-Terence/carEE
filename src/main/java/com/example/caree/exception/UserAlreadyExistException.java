package com.example.caree.exception;

public class UserAlreadyExistException extends Exception {

    public UserAlreadyExistException(String username) {
        super("user with username " + username + " already exist");
    }
}
