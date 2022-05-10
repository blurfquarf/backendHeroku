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

            roleRepository.saveAll(List.of(studentRole, promotorRole, coordinatorRole, bedrijfsV));


            User BJ = new User("BerendJaap","berend@gmail.com","wachtwoord");
            User geert = new User("GeertGoossens","mailo@gmail.com","wachtwoord");
            User dinos = new User("dinodelarue","maili@gmail.com","wachtwoord");
            User kurt = new User("kurt","kurt@gmail.com","wachtwoord");
            User dwight = new User("dwight","dwight@gmail.com","wachtwoord");
            User Kanye = new User("Kanye","mrwest@gmail.com","wachtwoord");
            User djef = new User("djef","djef@gmail.com","wachtwoord");

            User maxou = new User("maxou","maxou@gmail.com","wachtwoord");
            User toon = new User("toon","toon@gmail.com","wachtwoord");
            User matthieu = new User("matthieu","matthieu@gmail.com","wachtwoord");

            BJ.setRoles(Arrays.asList(roleRepository.findByName("ROLE_STUDENT")));
            maxou.setRoles(Arrays.asList(roleRepository.findByName("ROLE_STUDENT")));
            toon.setRoles(Arrays.asList(roleRepository.findByName("ROLE_STUDENT")));
            matthieu.setRoles(Arrays.asList(roleRepository.findByName("ROLE_STUDENT")));
            geert.setRoles(Arrays.asList(roleRepository.findByName("ROLE_PROMOTOR")));
            dwight.setRoles(Arrays.asList(roleRepository.findByName("ROLE_PROMOTOR")));
            dinos.setRoles(Arrays.asList(roleRepository.findByName("ROLE_COORDINATOR")));
            kurt.setRoles(Arrays.asList(roleRepository.findByName("ROLE_BEDRIJF")));
            Kanye.setRoles(Arrays.asList(roleRepository.findByName("ROLE_COORDINATOR")));
            djef.setRoles(Arrays.asList(roleRepository.findByName("ROLE_PROMOTOR")));


            Opleiding elict = new Opleiding("ELICT");
            Opleiding ned = new Opleiding("Nederlands");
            opleidingsRepository.saveAll(List.of(elict, ned));

            Campus G = new Campus("Gent");
            Campus B = new Campus("Brugge");
            Campus C = new Campus("Aalst");
            campusRepository.saveAll(List.of(G, B, C));



            Subject taartenBakken = new Subject("Taarten bakken", "sssss", true);
            Subject nanobots = new Subject("vroemvroem");
            Subject dinoos = new Subject("nog niet beslist");
            Subject n1 = new Subject("zinsbouw");
            Subject n2 = new Subject("zinnen");
            Subject n3 = new Subject("werkwoorden");


            dinoos.setOpleidingen(Arrays.asList(opleidingsRepository.findByName("ELICT")));
            nanobots.setOpleidingen(Arrays.asList(opleidingsRepository.findByName("ELICT"), opleidingsRepository.findByName("Nederlands")));
            taartenBakken.setOpleidingen(Arrays.asList(opleidingsRepository.findByName("Nederlands")));
            n1.setOpleidingen(Arrays.asList(opleidingsRepository.findByName("Nederlands")));
            n2.setOpleidingen(Arrays.asList(opleidingsRepository.findByName("Nederlands")));
            n3.setOpleidingen(Arrays.asList(opleidingsRepository.findByName("Nederlands")));


            dinoos.setCampussen(Arrays.asList(campusRepository.findByName("Gent")));
            nanobots.setCampussen(Arrays.asList(campusRepository.findByName("Gent")));
            taartenBakken.setCampussen(Arrays.asList(campusRepository.findByName("Brugge")));
            n1.setCampussen(Arrays.asList(campusRepository.findByName("Gent")));
            n2.setCampussen(Arrays.asList(campusRepository.findByName("Gent")));
            n3.setCampussen(Arrays.asList(campusRepository.findByName("Gent")));

            taartenBakken.setReedsGoedgekeurd();
            n1.setReedsGoedgekeurd();
            n3.setReedsGoedgekeurd();

            repository.saveAll(
                    List.of(taartenBakken, nanobots, dinoos, n1, n2, n3)
            );


            BJ.setSubjects(Arrays.asList(subjectRepository.findByName("nog niet beslist")));
            maxou.setSubjects(Arrays.asList(subjectRepository.findByName("nog niet beslist")));
            toon.setSubjects(Arrays.asList(subjectRepository.findByName("nog niet beslist")));
            matthieu.setSubjects(Arrays.asList(subjectRepository.findByName("nog niet beslist")));
            geert.setSubjects(Arrays.asList(subjectRepository.findByName("nog niet beslist")));
            dinos.setSubjects(Arrays.asList(subjectRepository.findByName("nog niet beslist")));
            kurt.setSubjects(Arrays.asList(subjectRepository.findByName("nog niet beslist")));
            dwight.setSubjects(Arrays.asList(subjectRepository.findByName("nog niet beslist")));
            Kanye.setSubjects(Arrays.asList(subjectRepository.findByName("nog niet beslist")));
            djef.setSubjects(Arrays.asList(subjectRepository.findByName("nog niet beslist")));


            BJ.setOpleiding(opleidingsRepository.findByName("ELICT"));
            geert.setOpleiding(opleidingsRepository.findByName("ELICT"));
            dinos.setOpleiding(opleidingsRepository.findByName("ELICT"));
            kurt.setOpleiding(opleidingsRepository.findByName("ELICT"));
            dwight.setOpleiding(opleidingsRepository.findByName("ELICT"));
            Kanye.setOpleiding(opleidingsRepository.findByName("Nederlands"));
            maxou.setOpleiding(opleidingsRepository.findByName("Nederlands"));
            toon.setOpleiding(opleidingsRepository.findByName("Nederlands"));
            matthieu.setOpleiding(opleidingsRepository.findByName("Nederlands"));
            djef.setOpleiding(opleidingsRepository.findByName("Nederlands"));


            BJ.setCampus(campusRepository.findByName("Gent"));
            maxou.setCampus(campusRepository.findByName("Gent"));
            toon.setCampus(campusRepository.findByName("Gent"));
            matthieu.setCampus(campusRepository.findByName("Gent"));
            geert.setCampus(campusRepository.findByName("Aalst"));
            dinos.setCampus(campusRepository.findByName("Gent"));
            kurt.setCampus(campusRepository.findByName("Brugge"));
            dwight.setCampus(campusRepository.findByName("Gent"));
            Kanye.setCampus(campusRepository.findByName("Gent"));
            djef.setCampus(campusRepository.findByName("Gent"));


            BJ.setKeuze1(subjectRepository.findByName("nog niet beslist"));
            BJ.setKeuze2(subjectRepository.findByName("nog niet beslist"));
            BJ.setKeuze3(subjectRepository.findByName("nog niet beslist"));

            maxou.setKeuze1(subjectRepository.findByName("nog niet beslist"));
            maxou.setKeuze2(subjectRepository.findByName("nog niet beslist"));
            maxou.setKeuze3(subjectRepository.findByName("nog niet beslist"));

            toon.setKeuze1(subjectRepository.findByName("nog niet beslist"));
            toon.setKeuze2(subjectRepository.findByName("nog niet beslist"));
            toon.setKeuze3(subjectRepository.findByName("nog niet beslist"));

            matthieu.setKeuze1(subjectRepository.findByName("nog niet beslist"));
            matthieu.setKeuze2(subjectRepository.findByName("nog niet beslist"));
            matthieu.setKeuze3(subjectRepository.findByName("nog niet beslist"));

            geert.setKeuze1(subjectRepository.findByName("nog niet beslist"));
            geert.setKeuze2(subjectRepository.findByName("nog niet beslist"));
            geert.setKeuze3(subjectRepository.findByName("nog niet beslist"));

            dinos.setKeuze1(subjectRepository.findByName("nog niet beslist"));
            dinos.setKeuze2(subjectRepository.findByName("nog niet beslist"));
            dinos.setKeuze3(subjectRepository.findByName("nog niet beslist"));


            kurt.setKeuze1(subjectRepository.findByName("nog niet beslist"));
            kurt.setKeuze2(subjectRepository.findByName("nog niet beslist"));
            kurt.setKeuze3(subjectRepository.findByName("nog niet beslist"));


            dwight.setKeuze1(subjectRepository.findByName("nog niet beslist"));
            dwight.setKeuze2(subjectRepository.findByName("nog niet beslist"));
            dwight.setKeuze3(subjectRepository.findByName("nog niet beslist"));


            Kanye.setKeuze1(subjectRepository.findByName("nog niet beslist"));
            Kanye.setKeuze2(subjectRepository.findByName("nog niet beslist"));
            Kanye.setKeuze3(subjectRepository.findByName("nog niet beslist"));


            djef.setKeuze1(subjectRepository.findByName("nog niet beslist"));
            djef.setKeuze2(subjectRepository.findByName("nog niet beslist"));
            djef.setKeuze3(subjectRepository.findByName("nog niet beslist"));



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
            try {
                userController.addNewPerson(Kanye);
            } catch (EmailExists e) {
                e.printStackTrace();
            }
            try {
                userController.addNewPerson(maxou);
            } catch (EmailExists e) {
                e.printStackTrace();
            }
            try {
                userController.addNewPerson(toon);
            } catch (EmailExists e) {
                e.printStackTrace();
            }
            try {
                userController.addNewPerson(matthieu);
            } catch (EmailExists e) {
                e.printStackTrace();
            }
            try {
                userController.addNewPerson(djef);
            } catch (EmailExists e) {
                e.printStackTrace();
            }


        };
    }
}
