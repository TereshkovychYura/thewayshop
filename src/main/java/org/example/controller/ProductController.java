package org.example.controller;

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
    @RequestMapping("/productList")
    public String getProducts(Model model){
        List<Product> products = productDao.getAllProducts();
        model.addAttribute("products", products);
        return "productList";
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
}