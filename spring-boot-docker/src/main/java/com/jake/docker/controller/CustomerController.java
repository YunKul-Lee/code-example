package com.jake.docker.controller;

import com.jake.docker.model.Customer;
import com.jake.docker.model.dto.CustomerDto;
import com.jake.docker.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;


    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomer() {
        List<Customer> allCustomers = customerService.getAllCustomers();
        return ResponseEntity.ok(allCustomers);
    }

    @PostMapping("/create")
    public ResponseEntity<CustomerDto> createCustomer(CustomerDto dto) {
        customerService.createCustomer(dto);
        return ResponseEntity.ok(dto);
    }
}
