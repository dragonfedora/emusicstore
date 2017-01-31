package com.emusic.spring.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSessionContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

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
    
    @RequestMapping(value="/admin/productInventory/addProduct", method=RequestMethod.POST)
    public String addProductPost(@ModelAttribute("product") Product product, HttpServletRequest request){
    	productDAO.addProduct(product);
    	MultipartFile productImage = product.getProductImage();
    	String rootPath = System.getProperty("user.home");
    	Path path = Paths.get(rootPath + "\\git\\emusicstore\\eMusicStore\\WebContent\\WEB-INF\\resources\\images\\" + product.getProductId() + ".png");
    	if( productImage != null && !productImage.isEmpty()){
    		
    		try {
				productImage.transferTo(new File(path.toString()));
			} catch (IllegalStateException | IOException e) {
				throw new RuntimeException("Product image saving failed");
			}
    	}
    	
    	return "redirect:/admin/productInventory";
    }
    
    @RequestMapping(value="/admin/productInventory/deleteProduct/{productId}")
    public String deleteProduct( @PathVariable("productId") String productId ){
    	productDAO.deletePrductById(productId);
    	return "redirect:/admin/productInventory";
    }
}


