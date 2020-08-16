package com.demo.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@Slf4j
@RestController
@RequestMapping("/employee")
public class FirstController {
    @Autowired
    RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

//    @Bean
//    public AlwaysSampler alwaysSampler() {
//        return new AlwaysSampler();
//    }

    private static final Logger LOG = Logger.getLogger(FirstController.class.getName());


    @GetMapping("/message")
    public String test() {
        log.info("tst...");
        LOG.info("Inside zipkinService 1..");

        String response = (String) restTemplate.exchange("http://localhost:8082/consumer/message",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
                }).getBody();
//        return "Hi...";

        return "Hello JavaInUse Called in First Service" + response;
    }
}
