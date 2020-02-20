package com.graphqljava.tutorial.bookdetails.rest;

import com.graphqljava.tutorial.bookdetails.dto.AuthorDTO;
import com.graphqljava.tutorial.bookdetails.dto.BookDTO;
import com.graphqljava.tutorial.bookdetails.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BooksController {

    @Autowired
    private BooksService booksService;

    @RequestMapping(value = "/books/{id}" , method = RequestMethod.GET)
    public ResponseEntity<BookDTO> getBookById(@PathVariable String id) {
        return ResponseEntity.ok(booksService.getBookByH2Id(id));
    }

    @RequestMapping(value = "/books" , method = RequestMethod.GET)
    public ResponseEntity<List<BookDTO>> getBooksFromH2() {
        return ResponseEntity.ok(booksService.getBooksFromH2());
    }

    @RequestMapping(value = "/authors" , method = RequestMethod.GET)
    public ResponseEntity<List<AuthorDTO>> getAuthorsFromH2() {
        return ResponseEntity.ok(booksService.getAuthorsFromH2());
    }

    @RequestMapping(value = "/book/add" , method = RequestMethod.POST)
    public ResponseEntity<BookDTO> addBook(@RequestBody BookDTO bookDTO) {
        booksService.addBook(bookDTO);
        return ResponseEntity.ok(bookDTO);
    }
}