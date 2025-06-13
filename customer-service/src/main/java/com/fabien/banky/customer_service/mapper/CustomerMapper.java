package com.fabien.banky.customer_service.mapper;

import com.fabien.banky.customer_service.dto.CustomerDTO;
import com.fabien.banky.customer_service.model.Customer;

public class CustomerMapper {
    public static Customer toEntity (CustomerDTO dto) {
        Customer customer = new Customer();
        customer.setFirstName(dto.firstName());
        customer.setLastName(dto.lastName());
        customer.setEmail(dto.email());

        return customer;
    }

    public static CustomerDTO toDto (Customer customer){
        return new CustomerDTO(customer.getId(),customer.getFirstName(), customer.getLastName(), customer.getEmail());
    }
}
