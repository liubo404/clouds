package com.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class SecondController {

    @GetMapping("/message")
    public String test() {
        return "Hello JavaInUse Called in Second Service";
    }

}
