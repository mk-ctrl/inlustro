package com.max.store.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.max.store.models.Products;
import com.max.store.services.ProductService;

@RestController
@CrossOrigin(
        origins = "http://localhost:8081",
        allowedHeaders = {"x-auth-token", "x-requested-with", "x-xsrf-token"}
)
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productservice;
	
	@GetMapping("/getall")
	public List<Products> GetProduct() {
		return productservice.getProduct();
	}
	@GetMapping("/find/{id}")
	public Optional<Products> FindProductByID(@PathVariable Long id) {
		return productservice.findproductbyID(id);
	}
	@PostMapping("/add")
	public Products AddProduct(@RequestBody Products product) {
		return productservice.addProduct(product);
	}
	@PutMapping("/edit/{id}")
	public String EditProduct(@RequestBody Products product, @PathVariable Long id) {
		return productservice.editProduct(product, id);
	}
	@DeleteMapping("/delete/{id}")
	public String DeletePRoduct(@PathVariable Long id) {
		return productservice.deleteProduct(id);
	}
}
