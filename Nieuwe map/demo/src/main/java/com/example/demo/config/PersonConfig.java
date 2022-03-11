package com.example.demo.config;

import com.example.demo.models.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class PersonConfig {



    @Autowired
    RoleRepository roleRepository;

    public void testCreateRoles(){
        Role student = new Role("STUDENT");
        Role promotor = new Role("PROMOTOR");
        Role coordinator = new Role("COORDINATOR");
        roleRepository.saveAll(List.of(student, promotor, coordinator));
        List<Role> listRoles = roleRepository.findAll();

    }
    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner commandLineRunner1(PersonRepository repository){
        return args -> {
            Person BJ = new Person("Berend-Jaap", "Vandevijvere");

            Person geert = new Person("Geert", "Gekkerd");

            Person dinos = new Person("Dino","Dinsdale");



            repository.saveAll(
                    List.of(BJ, geert, dinos)
            );
        };


    }

}
