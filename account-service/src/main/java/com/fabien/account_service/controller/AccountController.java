package com.fabien.account_service.controller;

import com.fabien.account_service.dto.Customer;
import com.fabien.account_service.model.Account;
import com.fabien.account_service.service.AccountService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;
    private final RestTemplate restTemplate;

    @Value("${customer.service.url}")
    private String customerServiceUrl;

    public AccountController(AccountService accountService, RestTemplate restTemplate) {
        this.accountService = accountService;
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public List<Account> getAll() {
        return accountService.getAll();
    }

    @GetMapping("/{id}/customer")
    public Customer getCustomerForAccount(@PathVariable UUID id){

        Account account = accountService.getAll()
                .stream()
                .filter(a->a.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Account not found"));

        return restTemplate.getForObject(customerServiceUrl+ "/customers/" + account.getCustomerId(),
                Customer.class
        );
    }

}
