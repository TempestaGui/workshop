package com.shop.Workshop.config;

import com.shop.Workshop.entity.User;
import com.shop.Workshop.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class instantiation implements CommandLineRunner {

    private final UserRepository userRepository;

    public instantiation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();

        User u1 = new User("Guilherme Tempesta","Guilherme@gmail.com","26/01/2004", null);
        User u2 = new User("Mara Cum", "Mara@gmail.com", "04/07/2010",null);
        User u3 = new User("Jamimo lhei", "Jaimo@gmail.com", "13/12/2001",null);
        User u4 = new User ("Tasco mido","Tasco@gmail.com", "10/10/1990",null);
        User u5 = new User("Sauldo pinto","Sauldo@gmail.com", "29/07/1997" ,null);

        userRepository.saveAll(Arrays.asList(u1,u2,u3,u4,u5));

    }
}
