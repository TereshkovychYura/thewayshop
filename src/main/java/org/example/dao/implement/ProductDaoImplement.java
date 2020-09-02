package org.example.dao.implement;

import org.example.dao.ProductDao;
import org.example.model.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Repository
@Transactional
public class ProductDaoImplement implements ProductDao {
    @Autowired
    private SessionFactory sessionFactory;



    public Product getProductById(String id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = (Product)session.get(Product.class, id);
        session.flush();
        return  product;
    }

    public List<Product> getAllProducts() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product");
        List<Product> products = query.list();
        session.flush();
        return  products;
    }

    public void addProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    public void deleteProduct(String id) {
        Session session=sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete Product where Id =" +id);
        query.executeUpdate();

        session.flush();
    }

    public void addToWishList(String id, boolean wish) {
        Session session=sessionFactory.getCurrentSession();
        Query query = session.createQuery("update Product set wish = " + wish + " where Id =" +id);
        query.executeUpdate();

        session.flush();
    }


    public List<Product> getProductsByName(String name) {
        Session session=sessionFactory.getCurrentSession();

        Query query=session.createQuery("from Product WHERE  Name  LIKE'%"+name+"%'");
        List<Product>products=query.list();
        session.flush();
        return products;
    }


    public void editProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }
}
