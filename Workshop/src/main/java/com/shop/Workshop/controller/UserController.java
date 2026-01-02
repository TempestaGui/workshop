package com.shop.Workshop.controller;

import com.shop.Workshop.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping
    public ResponseEntity<List<User> > findAll(){
        User maria = new User("Maria Brown","maria@gmail.com","1");
        User alex = new User("Alex Green","alex@gmail.com","2");

        return ResponseEntity.ok().body(new ArrayList<>(Arrays.asList(maria, alex)));
    }
}
