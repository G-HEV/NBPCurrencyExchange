package com.example.demo.currencyExchange.account.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class NoMoneyInAccountException extends RuntimeException {
    public NoMoneyInAccountException() {
        super("No money in account");
    }
}
