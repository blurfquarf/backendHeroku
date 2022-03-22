package com.example.demo.config;

import com.example.demo.controller.UserController;
import com.example.demo.models.*;
import com.example.demo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder(11);
    }

    @Bean
    CommandLineRunner commandLineRunner1(UserRepository userRepository, RoleRepository roleRepository, UserController userController){
        return args -> {

            User BJ = new User("Berend","Jaap","mail","wachtwoord");
            User geert = new User("Geert","Goossens","mail","wachtwoord");
            User dinos = new User("dino","delarue","mail","wachtwoord");

            BJ.setRoles(Arrays.asList(roleRepository.findByName("STUDENT")));
            geert.setRoles(Arrays.asList(roleRepository.findByName("PROMOTOR")));
            dinos.setRoles(Arrays.asList(roleRepository.findByName("STUDENT"),roleRepository.findByName("COORDINATOR")));

            List<Role> listRoles = roleRepository.findAll();

            userRepository.saveAll(List.of(BJ, geert, dinos));

            userController.registerNewPerson(BJ);
            userController.registerNewPerson(geert);
            userController.registerNewPerson(dinos);
        };

    }

}
