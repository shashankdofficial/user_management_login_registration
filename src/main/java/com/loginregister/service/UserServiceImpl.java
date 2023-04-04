package com.loginregister.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginregister.model.UserDetails;
import com.loginregister.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	public UserRepository userRepository;

	@Override
	public UserDetails createUser(UserDetails userDetails) {
		return userRepository.save(userDetails);
	}

	@Override
	public boolean checkEmail(String email) {
		return userRepository.existsByEmail(email);
	}
	
}
