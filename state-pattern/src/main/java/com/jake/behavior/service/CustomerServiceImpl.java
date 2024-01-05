package com.jake.behavior.service;

import com.jake.behavior.persistence.model.Customer;
import com.jake.behavior.persistence.repository.CustomerRepository;
import com.jake.behavior.state.ActiveState;
import com.jake.behavior.state.DeletedState;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepo;

    @Override
    public Customer createCustomer(String name, String email) {
        Customer newCustomer = Customer.builder()
                .name(name)
                .email(email)
                .state(new ActiveState())
                .build();

        newCustomer.performAction();

        return customerRepo.save(newCustomer);
    }

    @Override
    public void deleteCustomer(Long customerId) {
        Optional<Customer> customerOpt = getCustomerById(customerId);
        if(customerOpt.isPresent()) {
            Customer customer = customerOpt.get();

            customer.setState(new DeletedState());
            customer.performAction();
            customerRepo.delete(customer);
        }
    }

    private Optional<Customer> getCustomerById(Long id) {
        return customerRepo.findById(id);
    }
}
