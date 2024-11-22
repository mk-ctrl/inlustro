package com.max.store.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.max.store.models.Admins;
import com.max.store.repos.AdminRepo;

@Service
public class AdminService {

	@Autowired
	private AdminRepo adminrepo;
	
	public List<Admins> getAdmins() {
		return adminrepo.findAll();
	}
	public Admins addAdmins(Admins admin) {
		return adminrepo.save(admin);
	}
	public String adminLogin(String username, String password) {
		Admins adminx = adminrepo.findByAdminUsername(username);
		if(adminx ==null) {
			return "invalid_username";
		}
		else {		
			if (adminx.getAdminPassword().equals(password)) {
				return "auth";
			}
			else {
				return"invalid_password";
			}
			
			
		}
	}
	public String adminChangepassword(String username, String old_password, String new_password) {
		Admins adminx = adminrepo.findByAdminUsername(username);
		if (adminx == null) {
			return "invalid_useraname";
		}
		else {
			if(adminx.getAdminPassword().equals(old_password)) {
				adminx.setAdminPassword(new_password);
				adminrepo.saveAndFlush(adminx);
				return "password_changed";
			}
			else {
				return "invalid_old_password";
			}
		}
	}
}
