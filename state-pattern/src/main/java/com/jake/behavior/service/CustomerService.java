package com.jake.behavior.service;

import com.jake.behavior.persistence.model.Customer;

public interface CustomerService {

    Customer createCustomer(String name, String email);

    void deleteCustomer(Long customerId);
}
