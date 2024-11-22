package com.max.store.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.max.store.models.Products;

public interface ProductRepo extends JpaRepository<Products, Long> {

}
