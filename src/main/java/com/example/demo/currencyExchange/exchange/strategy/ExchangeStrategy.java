package com.example.demo.currencyExchange.exchange.strategy;

import com.example.demo.currencyExchange.account.model.Account;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface ExchangeStrategy {
    Account exchange(Account account, BigDecimal amount);
}