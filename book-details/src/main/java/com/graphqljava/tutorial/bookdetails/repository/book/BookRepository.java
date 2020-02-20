package com.graphqljava.tutorial.bookdetails.repository.book;

import com.graphqljava.tutorial.bookdetails.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository <Book, String> {
}
