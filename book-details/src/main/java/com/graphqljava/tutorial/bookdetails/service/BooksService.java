package com.graphqljava.tutorial.bookdetails.service;

import com.graphqljava.tutorial.bookdetails.dto.AuthorDTO;
import com.graphqljava.tutorial.bookdetails.dto.BookDTO;
import com.graphqljava.tutorial.bookdetails.model.Author;
import com.graphqljava.tutorial.bookdetails.repository.author.AuthorRepository;
import com.graphqljava.tutorial.bookdetails.model.Book;
import com.graphqljava.tutorial.bookdetails.repository.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BooksService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public void addBook(BookDTO bookDTO) {
        AuthorDTO authorDTO = bookDTO.getAuthor();
        Book book = new Book()
                .setId(bookDTO.getId())
                .setName(bookDTO.getName())
                .setPageCount(bookDTO.getPageCount())
                .setAuthorId(authorDTO.getId());


        Author author = new Author()
                .setId(authorDTO.getId())
                .setFirstName(authorDTO.getFirstName())
                .setLastName(authorDTO.getLastName());

        bookRepository.save(book);
        authorRepository.save(author);
    }

    public BookDTO getBookByH2Id(String id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        Book book = optionalBook.orElseGet(Book::new);
        return new BookDTO()
                .setId(String.valueOf(book.getId()))
                .setName(book.getName())
                .setPageCount(book.getPageCount())
                .setAuthor(mapAuthorToAuthorDTO(book.getAuthorId()));
    }


    public List<BookDTO> getBooksFromH2() {
        List<BookDTO> books = new ArrayList<>();

        bookRepository.findAll()
                .forEach(book1 -> {
                    books.add(new BookDTO()
                            .setId(book1.getId())
                            .setName(book1.getName())
                            .setPageCount(book1.getPageCount())
                            .setAuthor(mapAuthorToAuthorDTO(book1.getAuthorId())));
                });
        return books;

    }

    public List<AuthorDTO> getAuthorsFromH2() {
        List<AuthorDTO> authors = new ArrayList<>();

        authorRepository.findAll()
                .forEach(author -> {
                    authors.add(new AuthorDTO()
                            .setId(String.valueOf(author.getId()))
                            .setFirstName(author.getFirstName())
                            .setLastName(author.getLastName()));
                });
        return authors;

    }

    private AuthorDTO mapAuthorToAuthorDTO(String authorId) {
        Author author = authorRepository.findById(authorId).get();

        return new AuthorDTO()
                .setId(author.getId())
                .setFirstName(author.getFirstName())
                .setLastName(author.getLastName());

    }

}
