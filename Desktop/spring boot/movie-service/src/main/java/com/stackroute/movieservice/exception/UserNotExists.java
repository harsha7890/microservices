package com.stackroute.movieservice.exception;

import org.apache.logging.log4j.message.Message;

public class UserNotExists extends Exception{
    public UserNotExists(String message) {
        super(message);
    }

}
