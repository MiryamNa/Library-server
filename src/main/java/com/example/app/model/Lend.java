package com.example.app.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Lend {
    @Id
    @GeneratedValue
    private Long id;

    private LocalDate lendingDate;
    private LocalDate returnDate;
    @JsonIgnore
    @ManyToOne
    private Users user;
    @JsonIgnore
    @ManyToOne
    private Book book;
    @JsonCreator

    public Lend() {
    }

    public Lend(Long id, LocalDate lendingDate, Book book, LocalDate returnDate, Users user) {
        this.id = id;
        this.lendingDate = lendingDate;
        this.book = book;
        this.returnDate = returnDate;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getLendingDate() {
        return lendingDate;
    }

    public void setLendingDate(LocalDate lendingDate) {
        this.lendingDate = lendingDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users userName) {
        this.user = userName;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }




}
