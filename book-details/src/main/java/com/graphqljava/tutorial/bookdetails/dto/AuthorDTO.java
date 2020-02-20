package com.graphqljava.tutorial.bookdetails.dto;

import java.io.Serializable;

public class AuthorDTO implements Serializable {
    private String id;
    private String firstName;
    private String lastName;

    public String getId() {
        return id;
    }

    public AuthorDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public AuthorDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public AuthorDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
