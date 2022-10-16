package com.siit.course;

public class Author {

    String name;
    String email;

    public Author(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Author() {
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
