package com.libraryportal.portal.repositories;

//import java.awt.print.Book;
import com.libraryportal.portal.models.Books;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Books, Long> {

}
