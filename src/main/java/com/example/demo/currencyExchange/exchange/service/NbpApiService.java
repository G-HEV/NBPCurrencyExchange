package com.example.demo.currencyExchange.exchange.service;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface NbpApiService {
    BigDecimal getUSDRate();
}
