package com.example.demo.currencyExchange.account.service.Impl;

import com.example.demo.currencyExchange.account.exception.InsufficientMoneyException;
import com.example.demo.currencyExchange.account.exception.NoMoneyInAccountException;
import com.example.demo.currencyExchange.account.map.CreateAccountRequestToAccountMap;
import com.example.demo.currencyExchange.account.exception.AccountNotFoundException;
import com.example.demo.currencyExchange.account.model.CreateAccountRequest;
import com.example.demo.currencyExchange.account.service.AccountService;
import com.example.demo.currencyExchange.account.model.Account;
import com.example.demo.currencyExchange.user.exception.InsufficientUserDataException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {

    private final Map<UUID, Account> accounts = new HashMap<>();


    public Account createAccount(CreateAccountRequest createAccountRequest) {
        if (createAccountRequest.user().getName() == null || createAccountRequest.user().getSurname() == null) {
            throw new InsufficientUserDataException();
        }
        if (createAccountRequest.amount() == null) {
            throw new NoMoneyInAccountException();
        }
        Account account = CreateAccountRequestToAccountMap.createAccountToAccountMap(createAccountRequest);
        return save(account);
    }

    public Account save(Account account) {
        accounts.put(account.getId(), account);
        return account;
    }

    public Account getAccountById(UUID id) {
        return Optional.ofNullable(accounts.get(id))
                .orElseThrow(AccountNotFoundException::new);
    }

    public void update(Account account) {
        if (account.getBalanceUsd().signum() == -1 || account.getBalancePln().signum() == -1) {
            throw new InsufficientMoneyException("Insufficient funds in the account.");
        }
        accounts.put(account.getId(), account);
    }

}
