package com.libraryportal.portal.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer,handler"})
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;
	private String name;
	
	@OneToMany(mappedBy="user")
	private List<BookIssue> bookissue = new ArrayList<BookIssue>();
	
	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	

	public List<BookIssue> getBookissue() {
		return bookissue;
	}


	public void setBookissue(List<BookIssue> bookissue) {
		this.bookissue = bookissue;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "User [userid=" + userid + ", name=" + name + "]";
	}
	
}
