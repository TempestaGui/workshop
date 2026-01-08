package com.shop.Workshop.services;

import com.shop.Workshop.entity.Post;
import com.shop.Workshop.repository.PostRepository;
import com.shop.Workshop.services.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post findById(String id){
        return postRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Post Not Found!!"));
    }

    public List<Post> findAll(){ return postRepository.findAll(); }

    public List<Post> findByTitle(String text){
        return postRepository.findByTitleContainingIgnoreCase(text);
    }
}
