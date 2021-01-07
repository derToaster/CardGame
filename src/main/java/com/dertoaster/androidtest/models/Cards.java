package com.dertoaster.androidtest.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Cards {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String genre;
    String title;
    String text;

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("cards")
    Set<User> users = new HashSet<>();

    public Cards(Long id, String genre, String title, String text, Set<User> users) {
        this.id = id;
        this.genre = genre;
        this.title = title;
        this.text = text;
        this.users = users;
    }

    public Cards() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
