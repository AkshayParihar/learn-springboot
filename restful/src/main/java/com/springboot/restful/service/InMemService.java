package com.springboot.restful.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class InMemService {

    private final RestTemplate restTemplate;

    @Autowired
    public InMemService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @CircuitBreaker(name="externalCallHere")
    public String getData(){
        return restTemplate.getForObject("http://localhost:9090/api/external", String.class);
    }

}
