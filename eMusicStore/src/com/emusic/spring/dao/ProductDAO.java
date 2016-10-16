package com.emusic.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.emusic.spring.model.Product;

/**
 * Created by Madhuri on 03-09-2016.
 */
@Repository
public class ProductDAO {
    List<Product> productList = new ArrayList<Product>();

    public List<Product> getProductList(){
        Product product = new Product();
        product.setProductName("MI Max");
        product.setProductPrice(15000f);
        product.setProductCategory("Mobile");
        product.setProductDescription("6.44 phablet (BIG MOBILE)");
        product.setProductStatus("Not in stock");
        product.setUnitInStock(100);
        product.setProductId(1);
        productList.add(product);

        Product product2 = new Product();
        product2.setProductName("MI Max");
        product2.setProductPrice(15000f);
        product2.setProductCategory("Mobile");
        product2.setProductDescription("6.44 phablet (BIG MOBILE)");
        product2.setProductStatus("Not in stock");
        product2.setUnitInStock(100);
        product2.setProductId(2);
        productList.add(product2);

        Product product3 = new Product();
        product3.setProductName("MI Max");
        product3.setProductPrice(15000f);
        product3.setProductCategory("Mobile");
        product3.setProductDescription("6.44 phablet (BIG MOBILE)");
        product3.setProductStatus("Not in stock");
        product3.setUnitInStock(100);
        product3.setProductId(3);
        productList.add(product3);

        return productList;
    }

    public Product getProductById(int productId ) {
        for( Product product : getProductList()){
            if(productId == product.getProductId()){
                return product;
            }
        }
        return null;
    }
}
