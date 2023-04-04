package com.loginregister.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.loginregister.model.UserDetails;
import com.loginregister.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/createUser")
	public String createUser(@ModelAttribute UserDetails userDetails) {
		
//		System.out.println(userDetails);
		
		boolean f = userService.checkEmail(userDetails.getEmail());
		
		if(f) {
			System.out.println("Email Alredy Exist");
		}else {
			UserDetails user = userService.createUser(userDetails);
			if(user.getEmail() != null) {
				System.out.println("Registration Successfull");
			}else {
				System.out.println("Error on server");
			}
		}
		
		return "redirect:/register";
	}
}
