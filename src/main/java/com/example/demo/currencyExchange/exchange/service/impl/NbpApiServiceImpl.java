package com.example.demo.currencyExchange.exchange.service.impl;

import com.example.demo.currencyExchange.exchange.exception.NoNBPDataException;
import com.example.demo.currencyExchange.exchange.model.NBPResponse;
import com.example.demo.currencyExchange.exchange.service.NbpApiService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class NbpApiServiceImpl implements NbpApiService {
    private static final String NBP_API = "http://api.nbp.pl/api/exchangerates/rates/A/USD/";
    private static final String JSON_FORMAT = "?format=json";

    public BigDecimal getUSDRate() {
        RestTemplate restTemplate = new RestTemplate();
        try {
            NBPResponse response = restTemplate.getForObject(NBP_API + JSON_FORMAT, NBPResponse.class);

            if (response != null && !response.getRates().isEmpty()) {
                String mid = response.getRates().get(0).getMid();
                return new BigDecimal(mid);
            } else {
                throw new NoNBPDataException("No data on USD currency.");
            }

        } catch (RestClientResponseException e) {
            throw new NoNBPDataException("The exchange rate could not be downloaded from the NBP API.");
        }
    }
}
