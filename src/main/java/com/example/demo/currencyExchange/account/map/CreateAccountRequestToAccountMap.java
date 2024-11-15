package com.example.demo.currencyExchange.account.map;

import com.example.demo.currencyExchange.account.model.Account;
import com.example.demo.currencyExchange.account.model.CreateAccountRequest;
import com.example.demo.currencyExchange.user.model.User;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class CreateAccountRequestToAccountMap {

    public static Account createAccountToAccountMap(CreateAccountRequest createAccountRequest) {
        User user = new User(createAccountRequest.user().getName(),createAccountRequest.user().getSurname());
        return Account.builder()
                .id(UUID.randomUUID())
                .user(user)
                .balancePln(createAccountRequest.amount())
                .balanceUsd(BigDecimal.ZERO)
                .build();
    }
}
