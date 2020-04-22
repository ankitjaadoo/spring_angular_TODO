package com.libraryportal.portal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libraryportal.portal.models.BookIssue;

public interface BookIssueRepository extends JpaRepository<BookIssue, Number>{

}
