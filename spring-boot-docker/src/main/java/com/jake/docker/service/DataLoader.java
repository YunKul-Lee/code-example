package com.jake.docker.service;

import com.jake.docker.model.Customer;
import com.jake.docker.repository.CustomerRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader {


    private final CustomerRepository customerRepo;

    @PostConstruct
    public void init() {
        customerRepo.save(new Customer("Steve", "rogers"));
        customerRepo.save(new Customer("tony", "stark"));
    }
}
