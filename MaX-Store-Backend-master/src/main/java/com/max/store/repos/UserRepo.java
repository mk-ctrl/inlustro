package com.max.store.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.max.store.models.Users;

public interface UserRepo extends JpaRepository<Users, Long> {

	Users findByUserEmail(String email);

}
