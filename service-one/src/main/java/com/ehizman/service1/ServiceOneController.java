package com.ehizman.service1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/service-one")
public class ServiceOneController {
    private Logger logger = LoggerFactory.getLogger(ServiceOneController.class);

    @GetMapping
    public ResponseEntity<?> getResponse(){
        RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());
        String url = "http://localhost:8081/service-two";
        ResponseEntity<?> response = restTemplate.getForEntity(url, String.class);
        logger.info("Response body -> {}", response.getBody());
        logger.info("Response status -> {}", response.getStatusCode());
        return new ResponseEntity<>("Response from service 1", HttpStatus.OK);
    }

    //Override timeouts in request factory
    private SimpleClientHttpRequestFactory getClientHttpRequestFactory() {

        SimpleClientHttpRequestFactory clientHttpRequestFactory  = new SimpleClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(10_000);
        clientHttpRequestFactory.setReadTimeout(10_000);
        return clientHttpRequestFactory;
    }
}
