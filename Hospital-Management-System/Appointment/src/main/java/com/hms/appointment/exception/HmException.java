package com.hms.appointment.exception;

public class HmException extends Exception {

    public HmException(String message) {
        super(message);
    }

    public HmException(String message, Throwable cause) {
        super(message, cause);
    }
}
