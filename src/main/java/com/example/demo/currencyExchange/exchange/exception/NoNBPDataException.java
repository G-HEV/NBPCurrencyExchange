package com.example.demo.currencyExchange.exchange.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.SERVICE_UNAVAILABLE)
public class NoNBPDataException extends RuntimeException {
    public NoNBPDataException(String message) {
        super(message);
    }
}
