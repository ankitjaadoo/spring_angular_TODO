package com.libraryportal.portal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libraryportal.portal.exception.RecordNotFoundException;

import com.libraryportal.portal.models.BookIssue;
import com.libraryportal.portal.repositories.BookIssueRepository;

@Service
public class IssueService {
	     
	    @Autowired
	    BookIssueRepository bookIssueRepository;
	     
	    public List<BookIssue> getAllIssuedBooks()
	    {
	        List<BookIssue> bookIssueList = bookIssueRepository.findAll();
	         
	        if(bookIssueList.size() > 0) {
	            return bookIssueList;
	        } else {
	            return new ArrayList<BookIssue>();
	        }
	    }
	     
	    public BookIssue getIssueHistoryById(Long id) throws RecordNotFoundException 
	    {
	        Optional<BookIssue> bookIssue = bookIssueRepository.findById(id);
	         
	        if(bookIssue.isPresent()) {
	            return bookIssue.get();
	        } else {
	            throw new RecordNotFoundException("No employee record exist for given id");
	        }
	    }
	     
	    public BookIssue BookIssueUpdate(BookIssue bookIssue) throws RecordNotFoundException 
	    {
	        Optional<BookIssue> book_issue_update = bookIssueRepository.findById(bookIssue.getId());
	         
	        if(book_issue_update.isPresent()) 
	        {
	            BookIssue newEntity = book_issue_update.get();
	            newEntity.setBook(bookIssue.getBook());
	            newEntity.setUser(bookIssue.getUser());
	            newEntity.setIssuedfrom(bookIssue.getIssuedfrom());
	            newEntity.setIssuedtill(bookIssue.getIssuedtill());
	           
	            newEntity = bookIssueRepository.save(newEntity);
	             
	            return newEntity;
	        } else {
	            bookIssue = bookIssueRepository.save(bookIssue);
	             
	            return bookIssue;
	        }
	    } 
	     

}
