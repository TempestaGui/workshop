package com.shop.Workshop.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Document
public class User implements Serializable {

    private String name;
    private String email;
    private String id;

    public User(){}

    public User(String name, String email, String id){
        super();
        this.email = email;
        this.name = name;
        this.id = id;
    }

    public String getId(){return id;}

    public String getName(){return name;}

    public String getEmail(){return email;}

    public void setId(String id){this.id = id;}

    public void setName(String name){this.name = name;}

    public void setEmail(String email){this.email = email;}

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
