package com.example.service2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ServiceTwoController {
    private Logger logger = LoggerFactory.getLogger(ServiceTwoController.class);

    @GetMapping("/service-two")
    public ResponseEntity<?> getRequest() throws InterruptedException {
        logger.info("In Service Two");
        Thread.sleep(20000);
        return new ResponseEntity<>("Response from service 2", HttpStatus.OK);
    }
}
