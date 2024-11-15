package com.example.demo.currencyExchange.account.controller;

import com.example.demo.currencyExchange.account.model.Account;
import com.example.demo.currencyExchange.account.model.CreateAccountRequest;
import com.example.demo.currencyExchange.account.service.AccountService;
import com.example.demo.currencyExchange.exchange.model.EExchangeCurrency;
import com.example.demo.currencyExchange.exchange.service.ExchangeService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/accounts",produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountController {
    private final AccountService accountService;
    private final ExchangeService exchangeService;

    public AccountController(AccountService accountService, ExchangeService exchangeService) {
        this.accountService = accountService;
        this.exchangeService = exchangeService;
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody CreateAccountRequest createAccountRequest) {
        Account account = accountService.createAccount(createAccountRequest);
        return ResponseEntity.ok(account);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable UUID id) {
        return ResponseEntity.ok(accountService.getAccountById(id));
    }

    @PostMapping("/{id}/exchange")
    public ResponseEntity<Account> exchangeAmount(
            @PathVariable UUID id,
            @RequestParam("exchangeType") EExchangeCurrency exchangeType,
            @RequestBody BigDecimal amount) {
        Account account = accountService.getAccountById(id);
        account = exchangeService.exchange(account, exchangeType, amount);
        accountService.update(account);
        return ResponseEntity.ok(account);
    }
}
