package com.spring.Book.controller;

import com.spring.Book.entity.User;

import java.util.Objects;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.Book.service.UserService;

@Controller
public class RegisterController {
	
	@Autowired
	UserService userService;
	
	
	@GetMapping("/register")
	public String registerPage() {
		
		System.out.println("In register controller, Get Mapping...");
		
		return "register";
	}
	
	@PostMapping("/register")
	public String register(@RequestParam String email, @RequestParam String password, @RequestParam String name) {
		
		User user = new User();
		user.setUserName(name);
		user.setUserEmail(email);
		user.setPassword(password);
		
		System.out.println(user);
		
		if(!Objects.nonNull(user.getUserEmail()) || "".equalsIgnoreCase(user.getUserEmail())|| !Objects.nonNull(user.getPassword()) || "".equalsIgnoreCase(user.getPassword())
				|| !Objects.nonNull(user.getUserName()) || "".equalsIgnoreCase(user.getUserName()))
		return "register";
		
		try {
			userService.insertUser(user);
			System.out.println("Adding the User details...");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Redirecting to HOME...");
		return "redirect:home";
	}

}
