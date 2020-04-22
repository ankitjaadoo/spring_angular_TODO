package com.libraryportal.portal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

//import java.awt.print.Book;
import com.libraryportal.portal.models.Book;

public interface BookRepository extends JpaRepository<Book, Number> {

}
