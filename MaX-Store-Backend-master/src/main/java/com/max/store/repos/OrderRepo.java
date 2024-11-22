package com.max.store.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.max.store.models.Orders;

public interface OrderRepo extends JpaRepository<Orders, Long> {

}
