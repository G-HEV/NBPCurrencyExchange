package com.example.demo.currencyExchange.exchange.strategy;

import com.example.demo.currencyExchange.exchange.model.EExchangeCurrency;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ExchangeStrategyFactory {
    private final Map<EExchangeCurrency, ExchangeStrategy> strategies = new HashMap<>();

    public ExchangeStrategyFactory(PlnToUsdExchange plnToUsdStrategy, UsdToPlnExchange usdToPlnStrategy) {
        strategies.put(EExchangeCurrency.PLN_TO_USD, plnToUsdStrategy);
        strategies.put(EExchangeCurrency.USD_TO_PLN, usdToPlnStrategy);
    }

    public ExchangeStrategy getStrategy(EExchangeCurrency type) {
        ExchangeStrategy strategy = strategies.get(type);
        if (strategy == null) {
            throw new IllegalArgumentException("Stategy " + type + " is not supported");
        }
        return strategy;
    }
}
