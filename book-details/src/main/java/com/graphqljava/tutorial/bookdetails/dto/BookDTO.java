package com.graphqljava.tutorial.bookdetails.dto;

import java.io.Serializable;

public class BookDTO implements Serializable {
    private String id;
    private String name;
    private int pageCount;
    private AuthorDTO author;

    public String getName() {
        return name;
    }

    public BookDTO setName(String name) {
        this.name = name;
        return this;
    }

    public int getPageCount() {
        return pageCount;
    }

    public BookDTO setPageCount(int pageCount) {
        this.pageCount = pageCount;
        return this;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public BookDTO setAuthor(AuthorDTO author) {
        this.author = author;
        return this;
    }

    public String getId() {
        return id;
    }

    public BookDTO setId(String id) {
        this.id = id;
        return this;
    }
}
