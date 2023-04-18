package com.spring.Book.controller;

import java.util.*;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.Book.entity.Book;
import com.spring.Book.entity.User;
import com.spring.Book.service.BookService;
import com.spring.Book.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	BookService bookService;
	
	
	@GetMapping("/loggedin")
	public String loginPage()
	{
		//ModelAndView obj = new ModelAndView("login.jsp");
		System.out.println("In login controller, get Mapping");
		return "loggedin";
	}
	
	
	@PostMapping("/loginpage")
	public String loginPost(@RequestParam String email, @RequestParam String password, HttpSession session) {
		
		
		
		
		if(!Objects.nonNull(email) || "".equalsIgnoreCase(email)|| !Objects.nonNull(password) || "".equalsIgnoreCase(password))
		{
			return "loggedin";
			
		}
		
		if(email.equals("admin@gmail.com") && password.equals("admin"))
			{
			return "admin";
						
			}
			
		try {
			
			
			if(userService.validateUser(email, password)) {
				User newUser = userService.getUserByEmail(email);
				
				List<Book> books = bookService.getAllBooks();
				session.setAttribute("books", books);
				session.setAttribute("user", newUser);
				System.out.println("after setting up the attribute, going to dashboard...");
				return "redirect:userdashboard";
			}else {
				
				return "loggedin";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return "loggedin";
	}
	
	@GetMapping("/userdashboard")
	public String userdashboardLogin()
	{
		return "userdashboard";
	}
	

}
