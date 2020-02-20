package com.graphqljava.tutorial.bookdetails.grapql;

import com.graphqljava.tutorial.bookdetails.model.Author;
import com.graphqljava.tutorial.bookdetails.model.Book;
import com.graphqljava.tutorial.bookdetails.repository.author.AuthorRepository;
import com.graphqljava.tutorial.bookdetails.repository.book.BookRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GraphQLDataFetchers {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public GraphQLDataFetchers() {

    }

    public DataFetcher getBookByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            String bookId = dataFetchingEnvironment.getArgument("id");
            return bookRepository.findById(bookId).orElse(null);
        };
    }

    public DataFetcher getAuthorDataFetcher() {
        return dataFetchingEnvironment -> {
            Book book = dataFetchingEnvironment.getSource();
            String authorId = book.getAuthorId();
            return authorRepository.findById(authorId).orElse(null);
        };
    }

    public DataFetcher getPageCountDataFetcher() {
        return dataFetchingEnvironment -> {
            Book book = dataFetchingEnvironment.getSource();
            return book.getPageCount();
        };
    }

    public DataFetcher getBooksDataFetcher() {
        return dataFetchingEnvironment -> {
            List<Book> books = new ArrayList<>();
            bookRepository.findAll().forEach(book -> books.add(book));
            return books;
        };
    }

    public DataFetcher createBook() {
        return dataFetchingEnvironment -> {
            Book book = mapBook(dataFetchingEnvironment);
            bookRepository.save(book);
            authorRepository.save(mapAuthor(dataFetchingEnvironment));
            return book;
        };
    }

    private Author mapAuthor(DataFetchingEnvironment dataFetchingEnvironment) {
        String id = dataFetchingEnvironment.getArgument("authorId");
        String firstName = dataFetchingEnvironment.getArgument("authorFN");
        String lastName = dataFetchingEnvironment.getArgument("authorLN");

        return new Author()
                .setId(id)
                .setFirstName(firstName)
                .setLastName(lastName);
    }

    private Book mapBook(DataFetchingEnvironment dataFetchingEnvironment) {
        String bookId = dataFetchingEnvironment.getArgument("id");
        String name = dataFetchingEnvironment.getArgument("name");
        int pageCount = dataFetchingEnvironment.getArgument("pageCount");
        String authorId = dataFetchingEnvironment.getArgument("authorId");

        return new Book()
                .setId(bookId)
                .setName(name)
                .setPageCount(pageCount)
                .setAuthorId(authorId);
    }
}