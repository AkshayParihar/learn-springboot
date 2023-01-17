package com.springboot.restful;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.stream.IntStream;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application.properties")
public class ResilientUnitTest {

    @Autowired
    RestTemplate restTemplate;

    @RegisterExtension
    static WireMockExtension EXTERNAL_SERVICE = WireMockExtension.newInstance()
            .options(WireMockConfiguration.wireMockConfig()
                    .port(9090))
            .build();

    @Test
    public void testCircuitBreaker() {
        EXTERNAL_SERVICE.stubFor(WireMock.get("/api/external")
                .willReturn(serverError()));

        IntStream.rangeClosed(1, 5)
                .forEach(i -> {
                    ResponseEntity<String> response;
                    try {
                        response = restTemplate.getForEntity("http://localhost:8080/circuit-breaker", String.class);
                    }catch (HttpClientErrorException | HttpServerErrorException ex ) {
                        Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, ex.getStatusCode());
                    }
                });

        IntStream.rangeClosed(1, 5)
                .forEach(i -> {
                    ResponseEntity<String> response;
                    try {
                        response = restTemplate.getForEntity("http://localhost:8080/circuit-breaker", String.class);
                    }catch (HttpClientErrorException| HttpServerErrorException ex ) {
                        Assertions.assertEquals(HttpStatus.SERVICE_UNAVAILABLE, ex.getStatusCode());
                    }
                });

        EXTERNAL_SERVICE.verify(5, getRequestedFor(urlEqualTo("/api/external")));
    }
}
