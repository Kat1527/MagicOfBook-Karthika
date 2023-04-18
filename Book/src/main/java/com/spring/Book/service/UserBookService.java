package com.spring.Book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.Book.entity.User;
import com.spring.Book.entity.UserBook;
import com.spring.Book.repository.UserBookRepository;

@Service
public class UserBookService {
	
	@Autowired
	UserBookRepository userBookRepo;

	public void insertUserBook(UserBook userBook) throws Exception{
		// TODO Auto-generated method stub
		
		try {
			userBookRepo.save(userBook);
			System.out.println("Done with saving UserBook...");
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}

	public List<UserBook> getUserBookByReadLater(int userId) throws Exception{
		// TODO Auto-generated method stub
		
		try {
			return userBookRepo.getUserBookByReadLater(userId);
		}
		catch(Exception e)
		{
			throw new Exception("NO DATA FOUND...");
		}
		
	}

	public List<UserBook> getUserBookByLiked(int userId)  throws Exception{
		// TODO Auto-generated method stub
		try {
			return userBookRepo.getUserBookByLiked(userId);
		}
		catch(Exception e)
		{
			throw new Exception("NO DATA FOUND...");
		}
	}

	public void deleteUserbook(int userBookId) {
		// TODO Auto-generated method stub
		
		userBookRepo.deleteById(userBookId);
		
	}

}
