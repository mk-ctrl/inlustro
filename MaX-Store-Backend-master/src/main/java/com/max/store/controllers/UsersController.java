package com.max.store.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.max.store.models.Users;
import com.max.store.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(
        origins = "http://localhost:8081",
        allowedHeaders = {"x-auth-token", "x-requested-with", "x-xsrf-token"}
)
public class UsersController {
	@Autowired
	private UserService userservice;
	@GetMapping("/getall")
	public List<Users> Getusers() {
		return userservice.getUsers();
	}
	@GetMapping("/find/{id}")
	public Optional<Users> FindUserByID(@PathVariable Long id){
		return userservice.finduserbyId(id);
	}
	@PostMapping("/add")
	public Users AddUser(@RequestBody Users user) {
		return userservice.addUser(user);
	}
	@PostMapping("/login")
	public String LoginUser(@RequestBody Map<String, String> login) {
		String email=login.get("email");
		String password=login.get("password");
		return userservice.loginUser(email, password);
	}
	@PutMapping("/resetpassword")
	public String ResetPassword(@RequestBody Map<String, String> resetpassword) {
		String email=resetpassword.get("email");
		String old_password=resetpassword.get("old_password");
		String new_password=resetpassword.get("new_password");
		return userservice.resetPassword(email, old_password, new_password);
	}
	@PutMapping("/edit/{id}")
	public String EditUser(@PathVariable Long id, @RequestBody Users user) {
		return userservice.editUser(user, id);
	}
	@DeleteMapping("/delete/{id}")
	public String DeleteUser(@PathVariable Long id) {
		return userservice.deleteUser(id);
	}
}
