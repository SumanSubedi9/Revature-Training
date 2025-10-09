package com.revature.spring.restapi_application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NormalController {

    @GetMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "Hello from the normal controller!";
    }

}
