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

@Configuration
public class UserConfig {
/*
    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder(11);
    }*/

    @Bean
    CommandLineRunner commandLineRunner1(UserRepository userRepository,
                                         RoleRepository roleRepository,
                                         UserController userController,
                                         SubjectRepository subjectRepository,
                                         OpleidingsRepository opleidingsRepository) {
        return args -> {/*
            User BJ = new User("BerendJaap","berend@gmail.com","wachtwoord");
            User geert = new User("GeertGoossens","mailo@gmail.com","wachtwoord");
            User dinos = new User("dinodelarue","maili@gmail.com","wachtwoord");
            User kurt = new User("kurt","kurt@gmail.com","wachtwoord");

            BJ.setRoles(Arrays.asList(roleRepository.findByName("ROLE_STUDENT")));
            geert.setRoles(Arrays.asList(roleRepository.findByName("ROLE_PROMOTOR")));
            dinos.setRoles(Arrays.asList(roleRepository.findByName("ROLE_COORDINATOR")));
            kurt.setRoles(Arrays.asList(roleRepository.findByName("ROLE_BEDRIJF")));

            BJ.setSubjects(Arrays.asList(subjectRepository.findByName("nog niet beslist")));
            geert.setSubjects(Arrays.asList(subjectRepository.findByName("nog niet beslist")));
            dinos.setSubjects(Arrays.asList(subjectRepository.findByName("nog niet beslist")));
            kurt.setSubjects(Arrays.asList(subjectRepository.findByName("nog niet beslist")));

            BJ.setCampus("Gent");
            geert.setCampus("Kortrijk");
            dinos.setCampus("Aalst");
            kurt.setCampus("Gent");

            Opleiding elict = new Opleiding("ELICT");
            Opleiding ned = new Opleiding("Nederlands");
            opleidingsRepository.saveAll(List.of(elict, ned));

            BJ.setOpleiding(opleidingsRepository.findByName("ELICT"));
            geert.setOpleiding(opleidingsRepository.findByName("ELICT"));
            dinos.setOpleiding(opleidingsRepository.findByName("Nederlands"));
            kurt.setOpleiding(opleidingsRepository.findByName("ELICT"));

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
            try {
                userController.addNewPerson(kurt);
            } catch (EmailExists e) {
                e.printStackTrace();
            }*/
        };
    }}

