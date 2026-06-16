package com.example.app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String author;
    private String image;
    private String summary;
    private int pageCount;
    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonBackReference
    private Category category;
    @JsonIgnore
    @OneToMany (mappedBy="book")
    private List<Lend> lends;
    @OneToMany(mappedBy = "book")
    @JsonIgnore
    private List<Comment> comments;

    public Book() {
    }

    public Book(Long id, String title, String author, String image, String summary, int pageCount, Category category, List<Lend> lends, List<Comment> comments) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.image = image;
        this.summary = summary;
        this.pageCount = pageCount;
        this.category = category;
        this.lends = lends;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List<Lend> getLends() {
        return lends;
    }

    public void setLends(List<Lend> lends) {
        this.lends = lends;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }




}
