package com.fabien.banky.customer_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customers")
public class SimpleController {
    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}
