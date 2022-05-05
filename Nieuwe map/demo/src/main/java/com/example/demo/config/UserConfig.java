package com.example.demo.config;

import com.example.demo.checks.EmailExists;
import com.example.demo.controller.AuthController;
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

import static com.example.demo.models.ERole.ROLE_STUDENT;

@Configuration
public class UserConfig {

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder(11);
    }

    @Bean
    CommandLineRunner commandLineRunner1(UserRepository userRepository, RoleRepository roleRepository, UserController userController, SubjectRepository subjectRepository) {
        return args -> {


            User BJ = new User("BerendJaap","berend@gmail.com","wachtwoord");
            User geert = new User("GeertGoossens","mailo@gmail.com","wachtwoord");
            User dinos = new User("dinodelarue","maili@gmail.com","wachtwoord");

            BJ.setRoles(Arrays.asList(roleRepository.findByName("ROLE_STUDENT")));
            geert.setRoles(Arrays.asList(roleRepository.findByName("ROLE_PROMOTOR")));
            dinos.setRoles(Arrays.asList(roleRepository.findByName("ROLE_COORDINATOR")));


            BJ.setSubjects(Arrays.asList(subjectRepository.findByName("vroemvroem")));
            geert.setSubjects(Arrays.asList(subjectRepository.findByName("vroemvroem")));
            dinos.setSubjects(Arrays.asList(subjectRepository.findByName("nog niet beslist")));

            BJ.setCampus("Gent");
            geert.setCampus("Kortrijk");
            dinos.setCampus("Aalst");

            //List<Role> listRoles = roleRepository.findAll();

            //userRepository.saveAll(List.of(BJ, geert, dinos));

            try {
                userController.addNewPerson(BJ);
            } catch (EmailExists e) {
                e.printStackTrace();
            }

            try {
                userController.addNewPerson(geert);
            } catch (EmailExists e) {
                e.printStackTrace();
            }

            try {
                userController.addNewPerson(dinos);
            } catch (EmailExists e) {
                e.printStackTrace();
            }


        };
    }}

