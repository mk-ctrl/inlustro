package com.max.store.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.max.store.models.Products;
import com.max.store.repos.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productrepo;

	public List<Products> getProduct() {
		return productrepo.findAll();
	}

	public Optional<Products> findproductbyID(Long id) {
		return productrepo.findById(id);
	}

	public Products addProduct(Products product) {
		return productrepo.save(product);
	}

	public String editProduct(Products product, Long id) {
		Products productx = productrepo.findById(id).orElse(null);
		if (productx == null) {
			return "invalid_product";
		} else {
			productx.setProductName(product.getProductName());
			productx.setProductPrice(product.getProductPrice());
			productx.setProductDesc(product.getProductDesc());
			productx.setProductLogoUrl(product.getProductLogoUrl());
			productx.setProductCover1(product.getProductCover1());
			productx.setProductCover2(product.getProductCover2());
			productx.setProductCover3(product.getProductCover3());
			productrepo.saveAndFlush(productx);
			return "product_edited";
		}
	}

	public String deleteProduct(Long id) {
		productrepo.deleteById(id);
		return "product_deleted";
	}
}
