package com.example.demo.config;

import com.example.demo.checks.EmailExists;
import com.example.demo.controller.UserController;
import com.example.demo.models.Campus;
import com.example.demo.models.Opleiding;
import com.example.demo.models.Subject;
import com.example.demo.models.User;
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
            }

            Campus G = new Campus("Gent");
            Campus B = new Campus("Brugge");

            campusRepository.saveAll(List.of(G, B));

            Subject taartenBakken = new Subject("Taarten bakken", "sssss", true);

            Subject nanobots = new Subject("vroemvroem");

            Subject dinoos = new Subject("nog niet beslist");

            dinoos.addToCampussen(campusRepository.findByName("Gent"));
            dinoos.addToCampussen(campusRepository.findByName("Brugge"));

            dinoos.setOpleidingen(Arrays.asList(opleidingsRepository.findByName("ELICT")));
            nanobots.setOpleidingen(Arrays.asList(opleidingsRepository.findByName("ELICT"), opleidingsRepository.findByName("Nederlands")));
            taartenBakken.setOpleidingen(Arrays.asList(opleidingsRepository.findByName("Nederlands")));

            taartenBakken.setReedsGoedgekeurd();
/*

            taartenBakken.setPromotor(userRepository.findByUsername("GeertGoossens"));
            nanobots.setPromotor(userRepository.findByUsername("GeertGoossens"));
            dinos.setPromotor(userRepository.findByUsername("GeertGoossens"));
*/

            repository.saveAll(
                    List.of(taartenBakken, nanobots, dinoos)
            );
        };
    }
}
