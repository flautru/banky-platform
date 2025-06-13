package com.fabien.banky.customer_service.service;

import com.fabien.banky.customer_service.dto.CustomerDTO;
import com.fabien.banky.customer_service.mapper.CustomerMapper;
import com.fabien.banky.customer_service.model.Customer;
import com.fabien.banky.customer_service.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public CustomerDTO getCustomerById(UUID id){
        Customer customer = customerRepository.findById(id)
                .orElseThrow( () -> new EntityNotFoundException("Customer not found"));
        return CustomerMapper.toDto(customer);

    }
}
