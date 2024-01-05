package com.jake.behavior.state;

import com.jake.behavior.persistence.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class DeletedState implements State<Customer> {
    @Override
    public void performAction(Customer context) {
        closeAccounts(context);
        archiveData(context);
    }

    private void closeAccounts(Customer customer) {
        System.out.println("Close accounts");
    }

    private void archiveData(Customer customer) {
        System.out.println("Archive data");
    }
}
