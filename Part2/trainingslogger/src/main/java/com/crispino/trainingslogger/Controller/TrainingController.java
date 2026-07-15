package com.crispino.trainingslogger.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainingController{

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
    
}
