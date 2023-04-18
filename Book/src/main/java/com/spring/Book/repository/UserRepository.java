package com.spring.Book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Repository;


import com.spring.Book.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	public User findByUserEmailIgnoreCase(String userEmail);

}
