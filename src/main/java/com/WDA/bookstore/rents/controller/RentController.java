package com.WDA.bookstore.rents.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/rents")
public class RentController {

    @GetMapping
    public String hello(){
        return "Hello";
    }
}
