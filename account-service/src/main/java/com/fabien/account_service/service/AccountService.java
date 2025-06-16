package com.fabien.account_service.service;

import com.fabien.account_service.model.Account;
import com.fabien.account_service.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public List<Account> getAll() {
        return repository.findAll();
    }

    public Account save(Account account) {
        return repository.save(account);
    }
}
