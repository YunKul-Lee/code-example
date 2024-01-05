package com.jake.behavior.persistence.model;

import com.jake.behavior.state.ActiveState;
import com.jake.behavior.state.State;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Entity
@Builder
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @Transient
    @Setter
    private State<Customer> state;

    public Customer() {
        this.state = new ActiveState();
    }

    public void performAction() {
        state.performAction(this);
    }
}
