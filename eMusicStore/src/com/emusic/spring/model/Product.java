package com.emusic.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * Created by Madhuri on 03-09-2016.
 */
@Entity
public class Product {
	
	@GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
	@Id
	private String productId;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    private String productName;
    private String productCategory;
    private String productDescription;
    private float productPrice;
    private String productCondition;
    private String productStatus;
    private int unitInStock;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCondition() {
        return productCondition;
    }

    public void setProductCondition(String productCondition) {
        this.productCondition = productCondition;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public int getUnitInStock() {
        return unitInStock;
    }

    public void setUnitInStock(int unitInStock) {
        this.unitInStock = unitInStock;
    }
}
