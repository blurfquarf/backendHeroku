package com.example.demo.config;

import com.example.demo.checks.EmailExists;
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
public class MainConfig {
    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder(11);
    }

    @Bean
    CommandLineRunner commandLineRunner2(SubjectRepository repository, UserRepository userRepository,
                                         CampusRepository campusRepository,
                                         OpleidingsRepository opleidingsRepository,
                                         RoleRepository roleRepository,
                                         SubjectRepository subjectRepository,
                                         UserController userController) {
        return args -> {

            Role studentRole = new Role("ROLE_STUDENT");
            Role promotorRole = new Role("ROLE_PROMOTOR");
            Role coordinatorRole = new Role("ROLE_COORDINATOR");
            Role bedrijfsV = new Role("ROLE_BEDRIJF");
            //Role admin = new Role("ROLE_ADMIN");

            roleRepository.saveAll(List.of(studentRole, promotorRole, coordinatorRole, bedrijfsV));

            User BJ = new User("BerendJaap","berend@gmail.com","wachtwoord");
            User geert = new User("GeertGoossens","mailo@gmail.com","wachtwoord");
            User dinos = new User("dinodelarue","maili@gmail.com","wachtwoord");
            User kurt = new User("kurt","kurt@gmail.com","wachtwoord");
            User dwight = new User("dwight","dwight@gmail.com","wachtwoord");

            BJ.setRoles(Arrays.asList(roleRepository.findByName("ROLE_STUDENT")));
            geert.setRoles(Arrays.asList(roleRepository.findByName("ROLE_PROMOTOR")));
            dwight.setRoles(Arrays.asList(roleRepository.findByName("ROLE_PROMOTOR")));
            dinos.setRoles(Arrays.asList(roleRepository.findByName("ROLE_COORDINATOR")));
            kurt.setRoles(Arrays.asList(roleRepository.findByName("ROLE_BEDRIJF")));


            BJ.setSubjects(Arrays.asList(subjectRepository.findByName("nog niet beslist")));
            geert.setSubjects(Arrays.asList(subjectRepository.findByName("nog niet beslist")));
            dinos.setSubjects(Arrays.asList(subjectRepository.findByName("nog niet beslist")));
            kurt.setSubjects(Arrays.asList(subjectRepository.findByName("nog niet beslist")));
            dwight.setSubjects(Arrays.asList(subjectRepository.findByName("nog niet beslist")));

            Opleiding elict = new Opleiding("ELICT");
            Opleiding ned = new Opleiding("Nederlands");
            opleidingsRepository.saveAll(List.of(elict, ned));

            Campus G = new Campus("Gent");
            Campus B = new Campus("Brugge");
            Campus C = new Campus("Aalst");

            campusRepository.saveAll(List.of(G, B, C));

            BJ.setOpleiding(opleidingsRepository.findByName("ELICT"));
            geert.setOpleiding(opleidingsRepository.findByName("ELICT"));
            dinos.setOpleiding(opleidingsRepository.findByName("Nederlands"));
            kurt.setOpleiding(opleidingsRepository.findByName("ELICT"));
            dwight.setOpleiding(opleidingsRepository.findByName("ELICT"));

            BJ.setCampus(campusRepository.findByName("Gent"));
            geert.setCampus(campusRepository.findByName("Aalst"));
            dinos.setCampus(campusRepository.findByName("Gent"));
            kurt.setCampus(campusRepository.findByName("Brugge"));
            dwight.setCampus(campusRepository.findByName("Gent"));


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
            }
            try {
                userController.addNewPerson(dwight);
            } catch (EmailExists e) {
                e.printStackTrace();
            }


            Subject taartenBakken = new Subject("Taarten bakken", "sssss", true);

            Subject nanobots = new Subject("vroemvroem");

            Subject dinoos = new Subject("nog niet beslist");

            dinoos.addToCampussen(campusRepository.findByName("Gent"));
            dinoos.addToCampussen(campusRepository.findByName("Brugge"));

            dinoos.setOpleidingen(Arrays.asList(opleidingsRepository.findByName("ELICT")));
            nanobots.setOpleidingen(Arrays.asList(opleidingsRepository.findByName("ELICT"), opleidingsRepository.findByName("Nederlands")));
            taartenBakken.setOpleidingen(Arrays.asList(opleidingsRepository.findByName("Nederlands")));

            dinoos.setCampussen(Arrays.asList(campusRepository.findByName("Gent")));
            nanobots.setCampussen(Arrays.asList(campusRepository.findByName("Aalst")));
            taartenBakken.setCampussen(Arrays.asList(campusRepository.findByName("Brugge")));

            taartenBakken.setReedsGoedgekeurd();

            repository.saveAll(
                    List.of(taartenBakken, nanobots, dinoos)
            );
        };
    }
}
