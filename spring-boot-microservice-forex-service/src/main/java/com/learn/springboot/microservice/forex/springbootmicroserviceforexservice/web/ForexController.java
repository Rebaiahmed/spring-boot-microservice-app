package com.learn.springboot.microservice.forex.springbootmicroserviceforexservice.web;


import com.learn.springboot.microservice.forex.springbootmicroserviceforexservice.domain.ExchangeValue;
import com.learn.springboot.microservice.forex.springbootmicroserviceforexservice.repository.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class ForexController {

    @Autowired
    private Environment environment;

    @Autowired
    private ExchangeValueRepository repository;


    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retreiveExchangeValue(@PathVariable String from, @PathVariable String to)
    {
        ExchangeValue exchangeValue =
                repository.findByFromAndTo(from, to);

        exchangeValue.setPort(
                Integer.parseInt(Objects.requireNonNull(environment.getProperty("local.server.port"))));

        return exchangeValue;

    }
}
