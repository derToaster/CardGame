package com.dertoaster.androidtest.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_entity")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String username;
    String password;


    @ManyToMany(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("users")
    Set<Role> roles = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("users")
    Set<Cards> cards = new HashSet<>();

    public User(Long id, String username, String password, Set<Role> roles, Set<Cards> cards) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.cards = cards;
    }

    public User() {
    }

    public User(User user) {
        this.id = user.id;
        this.username = user.username;
        this.password = user.password;
        this.roles = user.roles;
        this.cards = user.cards;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Cards> getCards() {
        return cards;
    }

    public void setCards(Set<Cards> cards) {
        this.cards = cards;
    }
}
