package com.example.demo.currencyExchange.exchange.service;

import com.example.demo.currencyExchange.account.model.Account;
import com.example.demo.currencyExchange.exchange.model.EExchangeCurrency;

import java.math.BigDecimal;

public interface ExchangeService {

    Account exchange(Account account, EExchangeCurrency exchangeCurrency, BigDecimal amount);
}
