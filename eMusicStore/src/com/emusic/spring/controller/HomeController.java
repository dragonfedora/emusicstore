package com.emusic.spring.controller;

import com.emusic.spring.dao.ProductDAO;
import com.emusic.spring.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Madhuri on 02-09-2016.
 */
@Controller

public class HomeController {
	
	@Autowired
    private ProductDAO productDAO;
    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/productList")
    public String getProducts(Model model){
        List<Product> productList = productDAO.getProductList();
        model.addAttribute(productList);
        return "products";
    }

    @RequestMapping("/productList/productDetails")
    public String getProductDetails(){
        return "details";
    }

    @RequestMapping("/productList/viewProduct/{productId}")
    public String viewProductDetail(@PathVariable int productId, Model model){
        Product product = productDAO.getProductById(productId);
        model.addAttribute(product);
        return "details";
    }
}


