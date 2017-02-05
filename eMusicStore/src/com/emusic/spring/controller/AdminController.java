package com.emusic.spring.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

@Controller
public class AdminController {
	
	@Autowired
	private ProductDAO productDAO;

	@RequestMapping("/admin")
	public String viewAdminPage() {
		return "admin";
	}

	@RequestMapping("/admin/productInventory")
	public String viewInventory(Model model) {
		List<Product> productList = productDAO.getProductList();
		model.addAttribute("productList", productList);
		return "productInventory";
	}

	@RequestMapping("/admin/productInventory/addProduct")
	public String addProduct(Model model, Product product) {
		return "addProduct";
	}

	@RequestMapping(value = "/admin/productInventory/addProduct", method = RequestMethod.POST)
	public String addProductPost(@ModelAttribute("product") Product product, HttpServletRequest request) {
		productDAO.addProduct(product);
		transferFile(product);

		return "redirect:/admin/productInventory";
	}

	@RequestMapping(value = "/admin/productInventory/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable("productId") String productId) {
		productDAO.deletePrductById(productId);
		if (Files.exists(getSystemPath(productId))) {
			try {
				Files.delete(getSystemPath(productId));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "redirect:/admin/productInventory";
	}

	@RequestMapping(value = "/admin/productInventory/editProduct/{productId}")
	public String editProduct(@PathVariable("productId") String productId, Model model) {
		Product product = productDAO.getProduct(productId);
		model.addAttribute(product);
		return "addProduct";
	}

	@RequestMapping(value = "/admin/productInventory/editProduct/", method = RequestMethod.POST)
	public String editProduct(@ModelAttribute("product") Product product, Model model) {
		productDAO.editProduct(product);
		transferFile(product);
		return "redirect:/admin/productInventory";
	}

	private void transferFile(Product product) {
		MultipartFile productImage = product.getProductImage();
		if (productImage != null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(new File(getSystemPath(product.getProductId()).toString()));
			} catch (IllegalStateException | IOException e) {
				throw new RuntimeException("Product image saving failed");
			}
		}
	}

	private Path getSystemPath(String productId) {
		String rootPath = System.getProperty("user.home");
		return Paths.get(rootPath + "\\git\\emusicstore\\eMusicStore\\WebContent\\WEB-INF\\resources\\images\\"
				+ productId + ".png");

	}
}
