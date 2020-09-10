package org.example.dao;

import org.example.model.Cart;
import org.example.model.Product;

import java.util.List;

public interface CartDao {

    void addToCart(Product prod, int amount);

    void removeFromCart(Product prod);

    List<Product> getProductsFromCart();
}