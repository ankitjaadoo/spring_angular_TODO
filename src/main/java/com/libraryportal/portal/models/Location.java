package com.libraryportal.portal.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer,handler"})
public class Location {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long locid;
	@OneToOne
	private Book book;
	private int shelfnum;
	private int rownum;
	private int colnum;
	
	
	public long getLocid() {
		return locid;
	}


	public void setLocid(long locid) {
		this.locid = locid;
	}


	public Book getBook() {
		return book;
	}


	public void setBook(Book book) {
		this.book = book;
	}


	public int getShelfnum() {
		return shelfnum;
	}


	public void setShelfnum(int shelfnum) {
		this.shelfnum = shelfnum;
	}


	public int getRownum() {
		return rownum;
	}


	public void setRownum(int rownum) {
		this.rownum = rownum;
	}


	public int getColnum() {
		return colnum;
	}


	public void setColnum(int colnum) {
		this.colnum = colnum;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Locations [locid=" + locid + ", shelfnum=" + shelfnum + ", rownum=" + rownum + ", colnum=" + colnum + "]";
	}
	
	

}
