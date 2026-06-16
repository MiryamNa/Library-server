package com.example.app.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Long id;

    private String content;
    private LocalDate date;
    @JsonIgnore
    @ManyToOne
    private  Users user;
    @JsonIgnore
    @ManyToOne
    private  Book book;
    @JsonCreator

    public Comment() {
    }

    public Comment(Long id, String content, LocalDate date, Users user, Book book) {
        this.id = id;
        this.content = content;
        this.date = date;
        this.user = user;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }


}
