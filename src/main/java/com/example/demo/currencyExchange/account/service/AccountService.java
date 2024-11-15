package com.example.demo.currencyExchange.account.service;

import com.example.demo.currencyExchange.account.model.Account;
import com.example.demo.currencyExchange.account.model.CreateAccountRequest;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountService {

    Account createAccount(CreateAccountRequest account);
    Account save(Account account);
    Account getAccountById(UUID id);
    void update(Account account);

}
