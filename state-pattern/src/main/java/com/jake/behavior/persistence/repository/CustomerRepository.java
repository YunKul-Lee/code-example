package com.jake.behavior.persistence.repository;

import com.jake.behavior.persistence.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
