package org.example.dao;
import org.example.model.Product;
import java.util.List;

public interface ProductDao {
    Product getProductById(String id);
    List<Product> getAllProducts();
    void addProduct(Product product);
    void editProduct(Product product);
    void deleteProduct(String id);
    void addToWishList(String id, boolean wish);
    List<Product> getProductsByName(String name);
}
