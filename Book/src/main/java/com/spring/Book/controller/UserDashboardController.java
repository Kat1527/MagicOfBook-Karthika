package com.spring.Book.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.Book.entity.Book;
import com.spring.Book.entity.User;
import com.spring.Book.entity.UserBook;
import com.spring.Book.service.BookService;
import com.spring.Book.service.UserBookService;
import com.spring.Book.service.UserService;


@Controller
public class UserDashboardController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private BookService bookService;
	@Autowired
	private UserBookService userBookService;
	
//	@RequestMapping("/userdashboard")
//	public String dashboardPage(Map<String, List<Book>> map) {
//		
//		 
//			List<Book> books = bookService.getAllBooks();	
//		 
//		
//		map.put("books", books);
//		return "userdashboard";
//	}
	
	@GetMapping("/userdashboard/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		session.invalidate();
		return "redirect:/home";
	}
	
	@GetMapping("/readlater/{bookId}")
	public String addToReadlater(@PathVariable int bookId, HttpSession session) throws Exception {
		User user = (User) session.getAttribute("user");
		System.out.println(user);
		Book book = bookService.getBookById(bookId);
		boolean readLater = true;
		UserBook userBook = new UserBook();
		userBook.setUser(user);
		userBook.setBook(book);
		userBook.setReadLater(readLater);
		try {
			userBookService.insertUserBook(userBook);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "redirect:";
	}
	
	@GetMapping("/liked/{bookId}")
	public String addTolikedbook(@PathVariable int bookId, HttpSession session) throws Exception {
		User user = (User) session.getAttribute("user");
		System.out.println(user);
		Book book = bookService.getBookById(bookId);
		boolean readLater = true;
		UserBook userBook = new UserBook();
		userBook.setUser(user);
		userBook.setBook(book);
		userBook.setLiked(readLater);
		try {
			userBookService.insertUserBook(userBook);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "redirect:";
	}
	
	
	@GetMapping("/sortbooks")
	public ModelAndView sortBook() throws Exception
	{
		System.out.println("here in the sortBooks method, creating the MODELVIEW obj...");
		ModelAndView obj = new ModelAndView();
		obj.setViewName("userdashboard");
try {
	            
	            //User user = (User) session.getAttribute("user");
	            //System.out.println(user);
				List<Book> books = bookService.getAllSortedBooks();
//				session.setAttribute("books", books);
//				session.setAttribute("user", user);
				obj.addObject("books", books);
				
				System.out.println("here in the sortBooks method...");
				return obj;
			 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return obj;
	}

}
