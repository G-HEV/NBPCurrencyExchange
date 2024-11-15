package com.example.demo.currencyExchange.exchange.strategy;

import com.example.demo.currencyExchange.account.model.Account;
import com.example.demo.currencyExchange.exchange.service.NbpApiService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class UsdToPlnExchange implements ExchangeStrategy {

    private final NbpApiService nbpApiService;

    public UsdToPlnExchange(NbpApiService nbpApiService) {
        this.nbpApiService = nbpApiService;
    }

    @Override
    public Account exchange(Account account, BigDecimal amount) {
        BigDecimal rate = nbpApiService.getUSDRate();
        BigDecimal plnAmount = amount.multiply(rate).setScale(2, RoundingMode.HALF_UP);
        account.setBalanceUsd(account.getBalanceUsd().subtract(amount));
        account.setBalancePln(account.getBalancePln().add(plnAmount));
        return account;
    }
}
