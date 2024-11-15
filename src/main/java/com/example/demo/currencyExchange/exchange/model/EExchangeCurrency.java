package com.example.demo.currencyExchange.exchange.model;


public enum EExchangeCurrency {
    PLN_TO_USD("PLN to USD"),
    USD_TO_PLN("USD to PLN");

    public final String name;

     EExchangeCurrency(String name) {
        this.name = name;
    }
}
