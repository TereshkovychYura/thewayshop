package org.example.controller;

import org.example.dao.CartDao;
import org.example.dao.ProductDao;
import org.example.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private CartDao cartDao;
    @RequestMapping("/productList")
    public String getProducts(Model model){
        List<Product> products = productDao.getAllProducts();
        model.addAttribute("products", products);
        return "productList";
    }

    @RequestMapping("/cart")
    public String getCartProducts(Model model){
        List<Product> products = cartDao.getProductsFromCart();
        model.addAttribute("products", products);
        return "cart";
    }

    @RequestMapping("/wishList")
    public String getWishProducts(Model model){
        List<Product> products = productDao.getAllProducts();
        model.addAttribute("products", products);
        return "wishList";
    }

    @RequestMapping("/productList/viewProduct/{productId}")
    public String viewProduct(@PathVariable String productId , Model model) throws IOException {
        Product product = productDao.getProductById(productId);
        model.addAttribute(product);
        return "viewProduct";
    }

    @RequestMapping( value = "/productList/Search/", method = RequestMethod.POST)
    public String searchProduct(@RequestParam("Name") String Name, Model model) throws IOException {
        List<Product> products = productDao.getProductsByName(Name);
        model.addAttribute("products", products);
        return "productList";
    }

    @RequestMapping(value ="/productList/addToWishList/{Id}")
    public String addProductPost(@PathVariable String Id){
        Product product = productDao.getProductById(Id);
        if(product.getWish() == true) {
            productDao.addToWishList(Id, false);
        }
        else{
            productDao.addToWishList(Id, true);
        }
        return "redirect:/productList";
    }

    @RequestMapping(value ="/productList/addToCart/{Id}")
    public String addToCart(@PathVariable String Id){
        Product product = productDao.getProductById(Id);
        cartDao.addToCart(product,1);
        return "redirect:/productList";
    }

    @RequestMapping(value ="/productList/removeFromCart/{Id}")
    public String removeFromCart(@PathVariable String Id){
        Product product = productDao.getProductById(Id);
        cartDao.removeFromCart(product);
        return "redirect:/productList";
    }
}