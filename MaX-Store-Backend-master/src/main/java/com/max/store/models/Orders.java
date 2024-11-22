package com.max.store.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Orders {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	private String orderDate;
	private Float orderTotal;
	private Boolean orderStatus;
	private String fProductId;
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public Float getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(Float orderTotal) {
		this.orderTotal = orderTotal;
	}
	public Boolean getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Boolean orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getfProductId() {
		return fProductId;
	}
	public void setfProductId(String fProductId) {
		this.fProductId = fProductId;
	}
	
}
