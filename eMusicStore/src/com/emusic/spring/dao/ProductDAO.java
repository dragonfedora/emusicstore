package com.emusic.spring.dao;

import java.util.List;

import com.emusic.spring.model.Product;

public interface ProductDAO {
	
	public Product getProduct(String id);
	public void addProduct(Product product);
	public List<Product> getProductList();
	public void deletePrductById(String id);
	public void editProduct(Product product);

}
