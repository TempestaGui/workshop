package com.shop.Workshop.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Document
public class User implements Serializable {

    private String name;
    private String email;
    private String id;
    private String birthDate;

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

    public void setId(String id){this.id = id;}

    public void setName(String name){this.name = name;}

    public void setEmail(String email){this.email = email;}

    public void setBirthDate(String birthDate){this.birthDate = birthDate;}

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
