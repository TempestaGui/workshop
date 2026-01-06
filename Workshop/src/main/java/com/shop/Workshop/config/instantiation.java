package com.shop.Workshop.config;

import com.shop.Workshop.dto.AuthorDTO;
import com.shop.Workshop.entity.Post;
import com.shop.Workshop.entity.User;
import com.shop.Workshop.repository.PostRepository;
import com.shop.Workshop.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class instantiation implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public instantiation(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User u1 = new User("Guilherme Tempesta","Guilherme@gmail.com","26/01/2004", null);
        User u2 = new User("Mara Cum", "Mara@gmail.com", "04/07/2010",null);
        User u3 = new User("Jamimo lhei", "Jaimo@gmail.com", "13/12/2001",null);
        User u4 = new User ("Tasco mido","Tasco@gmail.com", "10/10/1990",null);
        User u5 = new User("Sauldo pinto","Sauldo@gmail.com", "29/07/1997" ,null);

        userRepository.saveAll(Arrays.asList(u1,u2,u3,u4,u5));

        Post p1 = new Post(null,sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para sao paulo. abraços!", new AuthorDTO(u1));
        Post p2 = new Post(null, sdf.parse("23/03/2018"), "Bom Dia", "Acordei feliz hoje!", new AuthorDTO(u1));

        postRepository.saveAll(Arrays.asList(p1, p2));

        u1.getPosts().addAll(Arrays.asList(p1, p2));

        userRepository.save(u1);
    }
}
