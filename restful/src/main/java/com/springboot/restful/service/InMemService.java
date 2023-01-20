package com.springboot.restful.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
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
    public String getData(String pass){
        HttpHeaders headers = new HttpHeaders();

        if("true".equals(pass)) {
            headers.set("X-PASS", "true");
        }else if("false".equals(pass)) {
            headers.set("X-PASS", "false");
        }else{
            throw new RuntimeException();
        }

        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange("http://localhost:9090/api/external", HttpMethod.GET, entity, String.class).toString();
    }

}
