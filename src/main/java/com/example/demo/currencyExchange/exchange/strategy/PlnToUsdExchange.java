package com.example.demo.currencyExchange.exchange.strategy;

import com.example.demo.currencyExchange.account.model.Account;
import com.example.demo.currencyExchange.account.service.AccountService;
import com.example.demo.currencyExchange.exchange.service.NbpApiService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class PlnToUsdExchange implements ExchangeStrategy {

    private final NbpApiService nbpApiService;

    public PlnToUsdExchange(NbpApiService nbpApiService) {
        this.nbpApiService = nbpApiService;
    }

    @Override
    public Account exchange(Account account, BigDecimal amount) {
        BigDecimal rate = nbpApiService.getUSDRate();
        BigDecimal usdAmount = amount.divide(rate, 2, RoundingMode.HALF_UP);
        account.setBalanceUsd(account.getBalanceUsd().add(usdAmount));
        account.setBalancePln(account.getBalancePln().subtract(amount));
        return account;
    }
}
