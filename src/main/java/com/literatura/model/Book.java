package com.literatura.model;

public class Book {
    private String title;
    private Author author;
    private String language;

    // Constructor
    public Book(String title, Author author, String language) {
        this.title = title;
        this.author = author;
        this.language = language;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public String getLanguage() {
        return language;
    }
}
