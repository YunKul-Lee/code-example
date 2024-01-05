package com.jake.behavior.persistence.state;

import com.jake.behavior.persistence.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class ActiveState implements State<Customer> {

    @Override
    public void performAction(Customer context) {
        sendWelcomeEmail(context);
        activateService(context);
    }

    private void sendWelcomeEmail(Customer customer) {
        System.out.println("Send welcome email!");
    }

    private void activateService(Customer customer) {
        System.out.println("Activate services");
    }
}
