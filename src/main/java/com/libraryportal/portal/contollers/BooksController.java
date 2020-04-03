package com.libraryportal.portal.contollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.libraryportal.portal.models.Books;
import com.libraryportal.portal.repositories.BookRepository;


@RestController
@RequestMapping("/api/v1/books")
public class BooksController {
	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping
	public List<Books> list(){
		
		return bookRepository.findAll();
				
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody Books book) {
		
		bookRepository.save(book);
	}
	
	@GetMapping("/{id}")
	public Books get(@PathVariable("id") long id) {
		
		return bookRepository.getOne(id);
	}

}
