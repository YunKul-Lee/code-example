package com.jake.docker.service;

import com.jake.docker.model.Customer;
import com.jake.docker.model.dto.CustomerDto;
import com.jake.docker.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepo;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    @Override
    public void createCustomer(CustomerDto dto) {
        if(ObjectUtils.isEmpty(dto)) {
            throw new IllegalArgumentException("Customer is Empty");
        }

        Customer customer = Customer.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .build();

        customerRepo.save(customer);
    }
}
