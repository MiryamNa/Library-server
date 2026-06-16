package com.example.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String password;
    private String tz;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String mail;
    private boolean status;
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Lend> lends;
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Comment> comments;

    public Users() {
    }

    public Users(Long id, String userName, String password, String firstName, String tz, String phoneNumber, String lastName, String mail, List<Lend> lends, boolean status, List<Comment> comments) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.tz = tz;
        this.phoneNumber = phoneNumber;
        this.lastName = lastName;
        this.mail = mail;
        this.lends = lends;
        this.status = status;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTz() {
        return tz;
    }

    public void setTz(String tz) {
        this.tz = tz;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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
