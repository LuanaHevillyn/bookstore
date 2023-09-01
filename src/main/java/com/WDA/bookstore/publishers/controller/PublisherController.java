package com.WDA.bookstore.publishers.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/publishers")
public class PublisherController {

    @GetMapping
    public String hello(){
        return "Hello";
    }
}
