package com.example.demo.currencyExchange.account.model;

import com.example.demo.currencyExchange.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {

    private UUID id;
    private User user;
    private BigDecimal balancePln;
    private BigDecimal balanceUsd;

}
