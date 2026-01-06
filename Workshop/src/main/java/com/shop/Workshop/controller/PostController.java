package com.shop.Workshop.controller;

import com.shop.Workshop.entity.Post;
import com.shop.Workshop.services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<List<Post>> findAll(){
        return ResponseEntity.ok().body(postService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        return ResponseEntity.ok().body(postService.findById(id));
    }
}
