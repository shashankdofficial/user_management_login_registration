package com.loginregister.service;

import com.loginregister.model.UserDetails;

public interface UserService {

	public UserDetails createUser(UserDetails userDetails);
	
	public boolean checkEmail(String email);
}
