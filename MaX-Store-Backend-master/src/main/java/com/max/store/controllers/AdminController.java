package com.max.store.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.max.store.models.Admins;
import com.max.store.services.AdminService;


@RestController
@RequestMapping("/admin")
@CrossOrigin(
        origins = "http://localhost:8081",
        allowedHeaders = {"x-auth-token", "x-requested-with", "x-xsrf-token"}
)
public class AdminController {
	@Autowired
	private AdminService adminservice;

	@GetMapping("/getall")
	public List<Admins> Getall() {
		return adminservice.getAdmins();
	}
	@PostMapping("/add")
	public Admins Addadmin(@RequestBody Admins admin){
		return adminservice.addAdmins(admin);
	}
	@PostMapping("/login")
	public String Login(@RequestBody Map<String, String> login) {
		String username = login.get("username");
		String password = login.get("password");
		return adminservice.adminLogin(username,password);
	}
	@PutMapping("/resetpassword")
	public String adminChangeStringPassword(@RequestBody Map<String, String> resetpassword) {
		String username = resetpassword.get("username");
		String old_password =resetpassword.get("old_password");
		String new_password = resetpassword.get("new_password");
		return adminservice.adminChangepassword(username, old_password, new_password);
	}
}
