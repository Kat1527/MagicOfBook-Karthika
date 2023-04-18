package com.spring.Book.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.spring.Book.entity.User;
import com.spring.Book.entity.UserBook;
import com.spring.Book.service.BookService;
import com.spring.Book.service.UserBookService;

@Controller
public class UserBookController {
	
	@Autowired
	private UserBookService userBookService;
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/readlater")
	public String readLater(Map<String, List<UserBook>> map, HttpSession session) {
		User user = (User) session.getAttribute("user");
		
		System.out.println("in here userbook controller, calling readlater...");
		
		try {
			List<UserBook> userBook = userBookService.getUserBookByReadLater(user.getUserId());
			map.put("userbook", userBook);
			return "readlater";
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return "userdashboard";

	}
	
	@GetMapping("/liked")
	public String liked(Map<String, List<UserBook>> map, HttpSession session)  {
		User user = (User) session.getAttribute("user");
		
		System.out.println("in here userbook controller, calling liked...");
		
		try {
			List<UserBook> userBook = userBookService.getUserBookByLiked(user.getUserId());
			map.put("userbook", userBook);
			return "liked";
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return "userdashboard";
	}
	
	@GetMapping("/removelike/{userbookid}")
	public String removeLiked(@PathVariable int userbookid) {
		userBookService.deleteUserbook(userbookid);
		return "redirect:/liked";
	}
	
	@GetMapping("/removereadlater/{userbookid}")
	public String removeReadlater(@PathVariable int userbookid) {
		userBookService.deleteUserbook(userbookid);
		return "redirect:/readlater";
	}
	

}
