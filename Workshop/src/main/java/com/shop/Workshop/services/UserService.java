package com.shop.Workshop.services;

import com.shop.Workshop.entity.User;
import com.shop.Workshop.services.exceptions.ObjectNotFoundException;
import com.shop.Workshop.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id){
        return userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Object not found!!"));
    }
}
