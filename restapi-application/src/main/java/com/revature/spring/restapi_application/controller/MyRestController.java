package com.revature.spring.restapi_application.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")

public class MyRestController {
    @RequestMapping("/greet")
    public String greet() {
        return "Hello from MyRestController!";
    }

}
