package com.graphqljava.tutorial.bookdetails.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {

    @Id
    private String id;

    private String name;
    private int pageCount;

    private String authorId;

    public Book () {

    }
    public Book (String name, int pageCount) {
        this.name = name;
        this.pageCount = pageCount;
    }

    public String getId() {
        return id;
    }

    public Book setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Book setName(String name) {
        this.name = name;
        return this;
    }

    public int getPageCount() {
        return pageCount;
    }

    public Book setPageCount(int pageCount) {
        this.pageCount = pageCount;
        return this;
    }

    public String getAuthorId() {
        return authorId;
    }

    public Book setAuthorId(String authorId) {
        this.authorId = authorId;
        return this;
    }
}
