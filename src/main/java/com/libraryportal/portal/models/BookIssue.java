package com.libraryportal.portal.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer,handler"})
public class BookIssue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToOne
	private Book book;
	@ManyToOne
	private User user;
	
	private Date issuedfrom;
	
	private Date issuedtill;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getIssuedfrom() {
		return issuedfrom;
	}

	public void setIssuedfrom(Date issuedfrom) {
		this.issuedfrom = issuedfrom;
	}

	public Date getIssuedtill() {
		return issuedtill;
	}

	public void setIssuedtill(Date issuedtill) {
		this.issuedtill = issuedtill;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


}
