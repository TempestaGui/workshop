package com.shop.Workshop.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document
public class User implements Serializable {

    @Id
    private String id;

    private String name;
    private String email;
    private String birthDate;

    @DBRef(lazy = true)
    private List<Post> posts = new ArrayList<>();

    public User(){}

    public User(String name, String email, String birthDate ,String id){
        super();
        this.email = email;
        this.name = name;
        this.id = id;
        this.birthDate = birthDate;
    }

    public String getId(){return id;}

    public String getName(){return name;}

    public String getEmail(){return email;}

    public String getBirthDate(){return birthDate;}

    public List<Post> getPosts() {return posts;}

    public void setId(String id){this.id = id;}

    public void setName(String name){this.name = name;}

    public void setEmail(String email){this.email = email;}

    public void setBirthDate(String birthDate){this.birthDate = birthDate;}

    public void setPosts(List<Post> posts) {this.posts = posts;}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
