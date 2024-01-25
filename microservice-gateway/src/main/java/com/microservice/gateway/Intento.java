package com.microservice.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aqui")
public class Intento {

    @GetMapping("/aqui")
    public String aqui(){
        return "Aqui";
    }

}
