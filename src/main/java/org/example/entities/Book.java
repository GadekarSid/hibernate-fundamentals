package org.example.entities;

import jakarta.persistence.Entity;

@Entity
public class Book extends Item{

    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
