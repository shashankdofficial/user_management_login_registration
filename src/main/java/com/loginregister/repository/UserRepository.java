package com.loginregister.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loginregister.model.UserDetails;

public interface UserRepository extends JpaRepository<UserDetails, Integer> {

	public boolean existsByEmail(String email);
}
