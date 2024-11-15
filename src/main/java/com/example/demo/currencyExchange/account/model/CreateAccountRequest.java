package com.example.demo.currencyExchange.account.model;

import com.example.demo.currencyExchange.user.model.User;

import java.math.BigDecimal;

public record CreateAccountRequest(User user, BigDecimal amount) {
}
