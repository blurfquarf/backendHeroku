package com.example.demo.config;

import com.example.demo.controller.PersonController;
import com.example.demo.models.*;
import com.example.demo.repository.*;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Configuration
public class PersonConfig {

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder(11);
    }

    @Bean
    CommandLineRunner commandLineRunner1(PersonRepository personRepository, RoleRepository roleRepository, PersonController personController){
        return args -> {

            Person BJ = new Person("Berend","Jaap","mail","wachtwoord");
            Person geert = new Person("Geert","Goossens","mail","wachtwoord");
            Person dinos = new Person("dino","delarue","mail","wachtwoord");


            BJ.setRoles(Arrays.asList(roleRepository.findByName("STUDENT")));
            geert.setRoles(Arrays.asList(roleRepository.findByName("PROMOTOR")));
            dinos.setRoles(Arrays.asList(roleRepository.findByName("STUDENT"),roleRepository.findByName("COORDINATOR")));

            //List<Role> listRoles = roleRepository.findAll();
            //personRepository.saveAll(List.of(BJ, geert, dinos));

            personController.registerNewPerson(BJ);
            personController.registerNewPerson(geert);
            personController.registerNewPerson(dinos);

        };

    }

}
