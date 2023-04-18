package com.spring.Book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.Book.entity.User;
import com.spring.Book.entity.UserBook;

@Repository
public interface UserBookRepository extends JpaRepository<UserBook, Integer> {
    
	@Query(value="SELECT * FROM USER_BOOK WHERE USER_ID=?1 AND READ_LATER=true", nativeQuery=true)
	public List<UserBook> getUserBookByReadLater(int userId);
	
	@Query(value="SELECT * FROM USER_BOOK WHERE USER_ID=?1 AND  LIKED_BOOKS=true", nativeQuery=true)
	public List<UserBook> getUserBookByLiked(int userId);
	
//	
//	@Query(
//			  value = "SELECT * FROM Book ORDER BY price",
//			  nativeQuery = true)

}
