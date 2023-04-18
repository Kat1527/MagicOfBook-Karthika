package com.spring.Book.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.spring.Book.entity.User;
import org.springframework.stereotype.Service;

import com.spring.Book.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	
	public User getUserByEmail(String email) throws Exception
	{
		try {
			User newUser = userRepo.findByUserEmailIgnoreCase(email);
			return newUser;
		}
		catch(Exception e)
		{
			throw new Exception("User does not exist with this email...");
		}
	}
	
	public boolean validateUser(String email, String password) throws Exception
	{
		try {
			User newUser = userRepo.findByUserEmailIgnoreCase(email);
			
			if(newUser.getPassword().equals(password)) return true;
		}
		catch (Exception e) {
			throw new Exception("Invalid Credentials...");	
		}
		
		
		return false;
	}
	
	public void insertUser(User user) throws Exception
	{
		
		try {
			userRepo.save(user);
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
