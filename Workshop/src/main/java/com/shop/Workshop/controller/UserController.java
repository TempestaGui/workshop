package com.shop.Workshop.controller;

import com.shop.Workshop.dto.UserDTO;
import com.shop.Workshop.entity.User;
import com.shop.Workshop.services.UserService;
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

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO> > findAll(){
        List<User> list = userService.findAll();
        List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).toList();

        return ResponseEntity.ok().body(listDTO);
    }
}
