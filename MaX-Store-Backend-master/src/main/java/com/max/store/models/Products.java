package com.max.store.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	private String productName;
	private String productDesc;
	private float productPrice;
	private String productCategory; 
	private String productLogoUrl;
	private String productCover1;
	private String productCover2;
	private String productCover3;
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductLogoUrl() {
		return productLogoUrl;
	}
	public void setProductLogoUrl(String productLogoUrl) {
		this.productLogoUrl = productLogoUrl;
	}
	public String getProductCover1() {
		return productCover1;
	}
	public void setProductCover1(String productCover1) {
		this.productCover1 = productCover1;
	}
	public String getProductCover2() {
		return productCover2;
	}
	public void setProductCover2(String productCover2) {
		this.productCover2 = productCover2;
	}
	public String getProductCover3() {
		return productCover3;
	}
	public void setProductCover3(String productCover3) {
		this.productCover3 = productCover3;
	}
	

		
}
