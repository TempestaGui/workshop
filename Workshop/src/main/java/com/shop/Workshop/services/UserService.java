package com.shop.Workshop.services;

import com.shop.Workshop.dto.UserDTO;
import com.shop.Workshop.entity.User;
import com.shop.Workshop.services.exceptions.ObjectNotFoundException;
import com.shop.Workshop.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
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
                .orElseThrow(() -> new ObjectNotFoundException("User not found!!"));
    }

    public User insert(User obj){
        return userRepository.insert(obj);
    }

    public User fromDTO(UserDTO objDTO){
        return new User(objDTO.getName(), objDTO.getEmail(), null ,objDTO.getId());
    }

    public void delete(String id){
        findById(id);
        userRepository.deleteById(id);
    }

    public void update(User obj){
        User newObj = userRepository.findById(obj.getId())
                .orElseThrow(() -> new ObjectNotFoundException("Object not found"));
        updateData(newObj, obj);
        userRepository.save(newObj);
    }

    private void updateData(User newObj, User obj){
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
        newObj.setBirthDate(obj.getBirthDate());
    }

    public List<User> findByBirthdate(Date date){
        return userRepository.findByBirthDate(date);
    }

    public List<User> findByName(String name){
        return userRepository.findByName(name);
    }
}
