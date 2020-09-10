package org.example.dao.implement;

import org.example.dao.CartDao;
import org.example.model.Cart;
import org.example.model.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class CartDaoImplement implements CartDao {
    @Autowired
    private SessionFactory sessionFactory;


    public void addToCart(Product prod, int amount) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(new Cart(prod, amount));
        session.flush();
    }

    public void removeFromCart(Product prod) {
        Session session=sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete Cart where Id =" +prod.getId());
        query.executeUpdate();

        session.flush();
    }

    public List<Product> getProductsFromCart() {
        Session session=sessionFactory.getCurrentSession();

        Query query=session.createQuery("from Cart");
        List<Cart> carts = query.list();

        query=session.createQuery("from Product");
        List<Product> products = query.list();

        List<Product> retproducts = new ArrayList<Product>();
        for (Cart cart: carts) {
            retproducts.add( (Product)session.get(Product.class, cart.getProductId()));
        }
        session.flush();
        return retproducts;
    }
}
