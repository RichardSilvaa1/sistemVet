package com.sistem.sisvet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Hellocontroler {

    @GetMapping("/")
    public String getMethodName() {
        return "new String()";
    }
    
}
