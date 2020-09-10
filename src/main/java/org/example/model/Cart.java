package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created on 08/09/2020.
 */

@Entity
public class Cart {
    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String Id;
    private String productId;
    private int amount;

    public Cart(Product prod, int amount){
        this.productId = prod.getId();
        this.amount = amount;
    }

    public Cart() {

    }
}