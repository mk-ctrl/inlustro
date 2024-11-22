package com.max.store.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.max.store.models.Orders;
import com.max.store.services.OrderService;

@RestController
@RequestMapping("/orders")
@CrossOrigin(
        origins = "http://localhost:8081",
        allowedHeaders = {"x-auth-token", "x-requested-with", "x-xsrf-token"}
)
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping("/getall")
	public List<Orders> GetOrder(){
		return orderService.getOrder();
	}
	@GetMapping("/find/{id}")
	public Optional<Orders> FindOrderByID(@PathVariable Long id){
		return orderService.findorderbyId(id);
	}
	@PostMapping("/add")
	public Orders AddOrder(@RequestBody Orders order) {
		return orderService.addOrder(order);
	}
}
