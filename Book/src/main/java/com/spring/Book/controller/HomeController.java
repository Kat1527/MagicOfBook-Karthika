package com.spring.Book.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.Book.entity.Book;
import com.spring.Book.service.BookService;


@Controller
public class HomeController {
	
	@Autowired
	BookService bookService;
	
	@RequestMapping("/home")
	public String helloPage()
	{
		//return "Hello from the trader's world!!! welcome to the journey so far, here I'm sitting at 1 Million USD";
		
//		String val = request.getParameter("value");
		
//		HttpSession session = request.getSession();
//		session.setAttribute("val", val);
		
		System.out.println("In home Controller...");
	
				
		return "home";
	}
	
	
	@GetMapping("/books")
	public String homepageBooks(Map<String, List<Book>> map) throws Exception{
		
		try {
			List<Book> books = bookService.getAllBooks();
			map.put("books", books);
			return "showbooks";
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return "showbooks";		
	}

}
