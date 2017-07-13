package com.kobitate.etimejava;

/**
 * Created by kobi on 7/11/17.
 */
public class ETimePasswordException extends Exception {
    public ETimePasswordException() {
        super("Incorrect Username or Password");
    }

    public ETimePasswordException(String message) {
        super(message);
    }
}
