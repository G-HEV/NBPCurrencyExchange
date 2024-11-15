package com.example.demo.currencyExchange.exchange.service.impl;

import com.example.demo.currencyExchange.account.model.Account;
import com.example.demo.currencyExchange.exchange.model.EExchangeCurrency;
import com.example.demo.currencyExchange.exchange.service.ExchangeService;
import com.example.demo.currencyExchange.exchange.strategy.ExchangeStrategy;
import com.example.demo.currencyExchange.exchange.strategy.ExchangeStrategyFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ExchangeServiceImpl implements ExchangeService {

    private final ExchangeStrategyFactory exchangeStrategyFactory;

    public ExchangeServiceImpl(ExchangeStrategyFactory exchangeStrategyFactory) {
        this.exchangeStrategyFactory = exchangeStrategyFactory;
    }

    @Override
    public Account exchange(Account account, EExchangeCurrency exchangeCurrency, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("The amount to be exchanged must be greater than zero.");
        }

        ExchangeStrategy strategy = exchangeStrategyFactory.getStrategy(exchangeCurrency);
        return strategy.exchange(account, amount);
    }
}
