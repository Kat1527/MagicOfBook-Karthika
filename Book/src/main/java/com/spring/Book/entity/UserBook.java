package com.spring.Book.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBook {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Id")
	private int id;
	
	@OneToOne
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private User user;
	@OneToOne
	@JoinColumn(name = "bookId", referencedColumnName = "bookId")
	private Book book;
	
	@Column(name="readLater")
	 private boolean readLater;
	@Column(name="likedBooks")
	 private boolean liked;

}