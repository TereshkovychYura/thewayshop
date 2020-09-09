package org.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private String customerId;






    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Id
    public String getCustomerId() {
        return customerId;
    }
}
