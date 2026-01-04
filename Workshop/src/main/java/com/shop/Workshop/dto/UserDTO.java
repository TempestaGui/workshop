package com.shop.Workshop.dto;

import com.shop.Workshop.entity.User;

import java.io.Serializable;
import java.util.Optional;

public class UserDTO implements Serializable {

    private String name;
    private String email;
    private String id;

    public UserDTO(){}

    public UserDTO(User obj){
        name = obj.getName();
        email = obj.getEmail();
        id = obj.getId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
