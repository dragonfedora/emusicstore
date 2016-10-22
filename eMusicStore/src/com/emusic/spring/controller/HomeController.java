package com.emusic.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.emusic.spring.dao.ProductDAO;
import com.emusic.spring.model.Product;

/**
 * Created by Madhuri on 02-09-2016.
 */
@Controller
public class HomeController {
	
	public HomeController() {
		System.out.println("HomeController.getProducts()--------------------");
	}
	
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
    public String viewProductDetail(@PathVariable String productId, Model model){
        Product product = productDAO.getProduct(productId);
        model.addAttribute(product);
        return "details";
    }
    
    @RequestMapping("/admin")
    public String viewAdminPage(){
        return "admin";
    }
    
    @RequestMapping("/admin/productInventory")
    public String viewInventory(Model model){
    	List<Product> productList = productDAO.getProductList();
    	model.addAttribute("productList", productList);
    	return "productInventory";
    }
    @RequestMapping("/admin/productInventory/addProduct")
    public String addProduct(Model model, Product product){
    	return "addProduct";
    }
}


