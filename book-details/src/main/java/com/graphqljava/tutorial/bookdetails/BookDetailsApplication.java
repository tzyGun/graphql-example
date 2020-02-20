package com.graphqljava.tutorial.bookdetails;

import com.graphqljava.tutorial.bookdetails.model.Author;
import com.graphqljava.tutorial.bookdetails.repository.author.AuthorRepository;
import com.graphqljava.tutorial.bookdetails.model.Book;
import com.graphqljava.tutorial.bookdetails.repository.book.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookDetailsApplication {


    public static void main(String[] args) {
        SpringApplication.run(BookDetailsApplication.class, args);
    }


    @Bean
    public CommandLineRunner bookDemo(BookRepository bookRepository, AuthorRepository authorRepository) {
        return (args) -> {

            // create books
            bookRepository.save(new Book()
                    .setId("book-1")
                    .setName("Harry Potter and the Philosopher's Stone")
                    .setPageCount(223)
                    .setAuthorId("author-1"));

            bookRepository.save(new Book()
                    .setId("book-2")

                    .setName("Moby Dick")
                    .setPageCount(635)
                    .setAuthorId("author-2"));

            bookRepository.save(new Book()
                    .setId("book-3")
                    .setName("Interview with the vampire")
                    .setPageCount(371)
                    .setAuthorId("author-3"));

            authorRepository.save(new Author()
                    .setId("author-1")
                    .setFirstName("Joanne")
                    .setLastName("Rowling"));

            authorRepository.save(new Author()
                    .setId("author-2")
                    .setFirstName("Herman")
                    .setLastName("Melville"));

            authorRepository.save(new Author()
                    .setId("author-3")
                    .setFirstName("Anne")
                    .setLastName("Rice"));

            System.out.println("!!!!!!!!!!!!!!!!!! SAMPLE DATA CREATED !!!!!!!!!!!!!!!!!!");

        };
    }

}
