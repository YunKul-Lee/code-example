package com.jake.docker.service;

import com.jake.docker.model.Customer;
import com.jake.docker.model.dto.CustomerDto;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomers();

    void createCustomer(CustomerDto dto);
}
