package com.max.store.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.max.store.models.Users;
import com.max.store.repos.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo usersrepo;

	public List<Users> getUsers() {
		return usersrepo.findAll();
	}

	public Users addUser(Users user) {
		return usersrepo.save(user);
	}
	public Optional<Users> finduserbyId(Long id) {
		return usersrepo.findById(id);
	}
	public String loginUser(String email, String password) {
		Users user = usersrepo.findByUserEmail(email);
		if (user == null) {
			return "invalid_email";
		} else {
			if (user.getUserPasswrod().equals(password)) {
				return "user_auth";
			} else {
				return "invalid_password";
			}
		}
	}

	public String resetPassword(String email, String old_password, String new_password) {
		Users user = usersrepo.findByUserEmail(email);
		if (user == null) {
			return "invalid_email";
		} else {
			if (user.getUserPasswrod().equals(old_password)) {
				user.setUserPasswrod(new_password);
				usersrepo.saveAndFlush(user);
				return "password_changed";
			} else {
				return "invalid_old_password";
			}
		}
	}
	public String editUser(Users user , Long id) {
		Users userx =usersrepo.findById(id).orElse(null);
		if(userx ==null) {
			return "invalid_user";
		}
		else {
			userx.setUserFirstname(user.getUserFirstname());
			userx.setUserLastname(user.getUserLastname());
			userx.setUserEmail(user.getUserEmail());
			userx.setUserPhone(user.getUserPhone());
			userx.setUserAddress(user.getUserAddress());
			usersrepo.saveAndFlush(userx);
			return "user_updated";
		}
	}
	public String deleteUser(Long id) {
		usersrepo.deleteById(id);
		return "user_deleted";
	}
}
