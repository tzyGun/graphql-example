package com.graphqljava.tutorial.bookdetails.repository.author;

import com.graphqljava.tutorial.bookdetails.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, String> {
}
