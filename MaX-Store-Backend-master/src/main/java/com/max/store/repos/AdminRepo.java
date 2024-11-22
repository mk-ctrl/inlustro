package com.max.store.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.max.store.models.Admins;

public interface AdminRepo extends JpaRepository<Admins, Long> {
    Admins findByAdminUsername(String adminUsername);
}
