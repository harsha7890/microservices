package com.stackroute.movieservice.exception;

import org.apache.logging.log4j.message.Message;

public class UserAlreadyexists extends Exception {
    public UserAlreadyexists(String message) {
        super(message);
    }
}
