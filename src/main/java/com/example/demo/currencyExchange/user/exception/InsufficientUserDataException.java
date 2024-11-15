package com.example.demo.currencyExchange.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InsufficientUserDataException extends RuntimeException {

    public InsufficientUserDataException() {
        super("Lack of user data");
    }
}
