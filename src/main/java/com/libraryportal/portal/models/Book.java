package com.libraryportal.portal.models;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


import com.libraryportal.portal.enums.BookStatus;

@Entity

public class Book {
	
	@OneToOne
	private Location location;
	@OneToOne
	private BookIssue bookissue;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String author;
	private long isbnnum;
	@Enumerated
	private BookStatus status;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public long getIsbnnum() {
		return isbnnum;
	}
	public void setIsbnnum(long isbnnum) {
		this.isbnnum = isbnnum;
	}
	
	
	public BookStatus getStatus() {
		return status;
	}
	public void setStatus(BookStatus status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Books [id=" + id + ", name=" + name + ", author=" + author + ", isbnnum=" + isbnnum + ", status=" + status + "]";
	}
	
	
	
}

