package com.spring.Book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.Book.entity.Book;
import com.spring.Book.repository.BookRepository;
@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepo;
	
	public List<Book> getAllBooks()
	{
		return bookRepo.findAll();
	}
	
	
	public void insertBook(Book book) throws Exception
	{
		try {
			bookRepo.save(book);
			System.out.println("Done with saving Book...");
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void deletionById(int bookId)
	{
				
		bookRepo.deleteById(bookId);
	}


	public Book getBookById(int bookId) throws Exception {
		// TODO Auto-generated method stub
		
		try {
			Book book = bookRepo.getById(bookId);
			return book;
		}
		catch(Exception e) {
			throw new Exception("Book with this ID does not exist...");
		}
		 
	}


	public List<Book> getAllSortedBooks() throws Exception{
		// TODO Auto-generated method stub
		try {
			List<Book> books = bookRepo.getAllSortedBooks();
			return books;
		}
		catch(Exception e)
		{
			throw new Exception("Books NOT available...");
		}
	}

}
