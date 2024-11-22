package com.max.store.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.max.store.models.Orders;
import com.max.store.repos.OrderRepo;

@Service
public class OrderService {
	@Autowired
	private OrderRepo orderrepo;
	
	public List<Orders> getOrder(){
		return orderrepo.findAll();
	}
	public Optional<Orders> findorderbyId(Long id){
		return orderrepo.findById(id);
	}
	public Orders addOrder(Orders order) {
		return orderrepo.save(order);
	}
}
