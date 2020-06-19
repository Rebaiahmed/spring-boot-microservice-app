package com.learn.springboot.microservice.forex.springbootmicroserviceforexservice.repository;

import com.learn.springboot.microservice.forex.springbootmicroserviceforexservice.domain.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends
        JpaRepository<ExchangeValue, Long> {

    ExchangeValue findByFromAndTo(String from, String to);
}
