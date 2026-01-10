package com.shop.Workshop.controller;

import com.shop.Workshop.dto.UserDTO;
import com.shop.Workshop.entity.Post;
import com.shop.Workshop.entity.User;
import com.shop.Workshop.repository.utils.URL;
import com.shop.Workshop.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findByID(@PathVariable String id){
        User user = userService.findById(id);
        return ResponseEntity.ok().body(new UserDTO(user));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDTO){
        User obj = userService.fromDTO(objDTO);
        obj = userService.insert(obj);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody UserDTO objDTO, @PathVariable String id){
        User obj = userService.fromDTO(objDTO);
        obj.setId(id);
        userService.update(obj);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/posts")
    public ResponseEntity<List<Post>> findUserPosts(@PathVariable String id){
        User obj = userService.findById(id);
        return ResponseEntity.ok().body(obj.getPosts());
    }

    @GetMapping("/birthdate")
    public ResponseEntity<List<UserDTO>> findByBirthdate(@RequestParam(value = "date") String date){
        Date birthdate = URL.convertDate(date, new Date());
        List<User> list = userService.findByBirthdate(birthdate);
        List<UserDTO> toDTO = list.stream().map(x -> new UserDTO(x)).toList();

        return ResponseEntity.ok().body(toDTO);
    }

    @GetMapping("/name")
    public ResponseEntity<List<UserDTO>> findByName(@RequestParam(value = "name") String name){
        name = URL.decodeParam(name);
        List<User> list = userService.findByName(name);
        List<UserDTO> toDTO = list.stream().map(x -> new UserDTO(x)).toList();

        return ResponseEntity.ok().body(toDTO);
    }
}
