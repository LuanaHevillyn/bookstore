package com.WDA.bookstore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/publisher")
public class PublisherController {
    @GetMapping
    public String hello(){
        return "Hello";
    }
}
