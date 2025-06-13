package com.fabien.banky.customer_service.controller;

import com.fabien.banky.customer_service.dto.CustomerDTO;
import com.fabien.banky.customer_service.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable UUID id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }
}
