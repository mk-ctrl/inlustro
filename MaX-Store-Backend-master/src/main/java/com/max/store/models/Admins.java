package com.max.store.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admins {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long adminId;
private String adminUsername;
private String adminPassword;
private int adminType;

public String getAdminUsername() {
	return adminUsername;
}
public void setAdminUsername(String adminUsername) {
	this.adminUsername = adminUsername;
}
public String getAdminPassword() {
	return adminPassword;
}
public void setAdminPassword(String adminPassword) {
	this.adminPassword = adminPassword;
}
public int getAdminType() {
	return adminType;
}
public void setAdminType(int adminType) {
	this.adminType = adminType;
}



}
