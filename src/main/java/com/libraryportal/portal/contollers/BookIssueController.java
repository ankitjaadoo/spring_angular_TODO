package com.libraryportal.portal.contollers;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.libraryportal.portal.models.BookIssue;
import com.libraryportal.portal.exception.RecordNotFoundException;
import com.libraryportal.portal.service.IssueService;
 
@RestController
@RequestMapping("/books/issue")
public class BookIssueController 
{
    @Autowired
    IssueService service;
 
    @GetMapping
    public ResponseEntity<List<BookIssue>> getAllIssuedBooks() {
        List<BookIssue> list = service.getAllIssuedBooks();
 
        return new ResponseEntity<List<BookIssue>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}/issue-history")
    public ResponseEntity<BookIssue> getIssueHistoryById(@PathVariable("id") Long id) 
                                                    throws RecordNotFoundException {
        BookIssue bookIssue = service.getIssueHistoryById(id);
 
        return new ResponseEntity<BookIssue>(bookIssue, new HttpHeaders(), HttpStatus.OK);
    }
 
    @PostMapping
    public ResponseEntity<BookIssue> BookIssueUpdate(BookIssue bookIssue)
                                                    throws RecordNotFoundException {
        BookIssue updated = service.BookIssueUpdate(bookIssue);
        return new ResponseEntity<BookIssue>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
 
}