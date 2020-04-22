package com.libraryportal.portal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libraryportal.portal.exception.RecordNotFoundException;
import com.libraryportal.portal.models.Book;
import com.libraryportal.portal.repositories.BookRepository;

@Service
public class BookService {
	     
	    @Autowired
	    BookRepository bookRepository;
	     
	    public List<Book> getAllBooks()
	    {
	        List<Book> employeeList = bookRepository.findAll();
	         
	        if(employeeList.size() > 0) {
	            return employeeList;
	        } else {
	            return new ArrayList<Book>();
	        }
	    }
	     
	    public Book getBookById(Long id) throws RecordNotFoundException 
	    {
	        Optional<Book> book = bookRepository.findById(id);
	         
	        if(book.isPresent()) {
	            return book.get();
	        } else {
	            throw new RecordNotFoundException("No employee record exist for given id");
	        }
	    }
	     
	    public Book createOrUpdateBook(Book book) throws RecordNotFoundException 
	    {
	        Optional<Book> book_to_update = bookRepository.findById(book.getId());
	         
	        if(book_to_update.isPresent()) 
	        {
	            Book newEntity = book_to_update.get();
	            newEntity.setName(book.getName());
	            newEntity.setAuthor(book.getAuthor());
	            newEntity.setIsbnnum(book.getIsbnnum());
	            newEntity.setStatus(book.getStatus());
	           
	            newEntity = bookRepository.save(newEntity);
	             
	            return newEntity;
	        } else {
	            book = bookRepository.save(book);
	             
	            return book;
	        }
	    } 
	     
	    public void deleteBookById(Long id) throws RecordNotFoundException 
	    {
	        Optional<Book> book_to_delete = bookRepository.findById(id);
	         
	        if(book_to_delete.isPresent()) 
	        {
	            bookRepository.deleteById(id);
	        } else {
	            throw new RecordNotFoundException("No employee record exist for given id");
	        }
	    } 
}

