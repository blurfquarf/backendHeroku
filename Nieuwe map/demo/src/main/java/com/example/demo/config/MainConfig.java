package com.example.demo.config;

import com.example.demo.checks.EmailExists;
import com.example.demo.controller.UserController;
import com.example.demo.models.*;
import com.example.demo.repository.*;
import com.example.demo.service.SubjectService;
import com.example.demo.service.UserService;
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
                                         UserController userController,
                                         SubjectService subjectService,
                                         UserService userService) {
        return args -> {

            Role studentRole = new Role("ROLE_STUDENT");
            Role promotorRole = new Role("ROLE_PROMOTOR");
            Role coordinatorRole = new Role("ROLE_COORDINATOR");
            Role bedrijfsV = new Role("ROLE_BEDRIJF");

            roleRepository.saveAll(List.of(studentRole, promotorRole, coordinatorRole, bedrijfsV));


            User BJ = new User("BerendJaap","berend@gmail.com","wachtwoord");
            User geert = new User("GeertGoossens","geert@gmail.com","wachtwoord");
            User dinos = new User("dinodelarue","dino@gmail.com","wachtwoord");
            User kurt = new User("AB Inbev","kurt@gmail.com","wachtwoord");
            User dwight = new User("dwight","dwight@gmail.com","wachtwoord");
            User Kanye = new User("Kanye","mrwest@gmail.com","wachtwoord");
            User djef = new User("Jef De Bakker","djef@gmail.com","wachtwoord");
            User maxou = new User("maxou","maxou@gmail.com","wachtwoord");
            User toon = new User("toon","toon@gmail.com","wachtwoord");
            User matthieu = new User("matthieu","matthieu@gmail.com","wachtwoord");
            User dirk = new User("Dirk Vanmaldeghem","dirk@gmail.com","wachtwoord");

            User zorakthegreat = new User("zorak","zorak@gmail.com","wachtwoord");


            User apple = new User("apple","apple@gmail.com","wachtwoord");
            User shady = new User("topbedrijf","topbedrijf@gmail.com","wachtwoord");





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
            dirk.setRoles(Arrays.asList(roleRepository.findByName("ROLE_PROMOTOR")));

            shady.setRoles(Arrays.asList(roleRepository.findByName("ROLE_BEDRIJF")));
            apple.setRoles(Arrays.asList(roleRepository.findByName("ROLE_BEDRIJF")));



            zorakthegreat.setRoles(Arrays.asList(roleRepository.findByName("ROLE_STUDENT")));

            Opleiding elict = new Opleiding("ELICT");
            Opleiding ned = new Opleiding("EM");
            opleidingsRepository.saveAll(List.of(elict, ned));

            Campus G = new Campus("Gent");
            Campus B = new Campus("Brugge");
            Campus C = new Campus("Aalst");
            campusRepository.saveAll(List.of(G, B, C));



            Subject taartenBakken = new Subject("Taarten bakken", "Droom jij ook over taarten? Kijk niet verder, dit is het onderwerp voor jou!", true);
            Subject nanobots = new Subject("fortnite", "DIKKE PARTY BIJ DE BATTLEBUS!", false);
            Subject dinoos = new Subject("nog niet beslist", "ok dit is cool", false);
            Subject n1 = new Subject("zinsbouw", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", true);
            Subject n2 = new Subject("zinnen", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", true);
            Subject n3 = new Subject("werkwoorden", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", true);


            Subject zorak = new Subject("greatness", "Maxou Van Lauwe is definitie hiervoor", true);



            Subject terminals = new Subject("terminals", "de terminal is een en al epicness", false);
            Subject robots = new Subject("AI malware", "dit is cool", true);
            Subject optimalisatie = new Subject("optimalisatiesoftware", "ok dit is cool", true);






            dinoos.setOpleidingen(Arrays.asList(opleidingsRepository.findByName("ELICT")));
            nanobots.setOpleidingen(Arrays.asList(opleidingsRepository.findByName("ELICT"), opleidingsRepository.findByName("EM")));
            taartenBakken.setOpleidingen(Arrays.asList(opleidingsRepository.findByName("EM")));
            n1.setOpleidingen(Arrays.asList(opleidingsRepository.findByName("EM")));
            n2.setOpleidingen(Arrays.asList(opleidingsRepository.findByName("EM")));
            n3.setOpleidingen(Arrays.asList(opleidingsRepository.findByName("EM")));

            zorak.setOpleidingen(Arrays.asList(opleidingsRepository.findByName("ELICT")));


            terminals.setOpleidingen(Arrays.asList(opleidingsRepository.findByName("ELICT"), opleidingsRepository.findByName("EM")));
            robots.setOpleidingen(Arrays.asList(opleidingsRepository.findByName("ELICT"), opleidingsRepository.findByName("EM")));
            optimalisatie.setOpleidingen(Arrays.asList(opleidingsRepository.findByName("ELICT"), opleidingsRepository.findByName("EM")));



            dinoos.setCampussen(Arrays.asList(campusRepository.findByName("Gent")));
            nanobots.setCampussen(Arrays.asList(campusRepository.findByName("Gent")));
            taartenBakken.setCampussen(Arrays.asList(campusRepository.findByName("Gent")));
            n1.setCampussen(Arrays.asList(campusRepository.findByName("Gent")));
            n2.setCampussen(Arrays.asList(campusRepository.findByName("Gent")));
            n3.setCampussen(Arrays.asList(campusRepository.findByName("Gent")));

            zorak.setCampussen(Arrays.asList(campusRepository.findByName("Gent")));

            terminals.setCampussen(Arrays.asList(campusRepository.findByName("Gent"), campusRepository.findByName("Brugge"), campusRepository.findByName("Aalst")));
            robots.setCampussen(Arrays.asList(campusRepository.findByName("Gent"), campusRepository.findByName("Brugge"), campusRepository.findByName("Aalst")));
            optimalisatie.setCampussen(Arrays.asList(campusRepository.findByName("Gent"), campusRepository.findByName("Brugge"), campusRepository.findByName("Aalst")));


            robots.setReedsGoedgekeurd();
            optimalisatie.setReedsGoedgekeurd();
            taartenBakken.setReedsGoedgekeurd();
            //dinoos.setReedsGoedgekeurd();
            n1.setReedsGoedgekeurd();
            n2.setReedsGoedgekeurd();
            n3.setReedsGoedgekeurd();
            zorak.setReedsGoedgekeurd();

        /*  taartenBakken.setBedrijf(apple);
            nanobots.setBedrijf(apple);
            n1.setBedrijf(apple);
            n2.setBedrijf(apple);
            n3.setBedrijf(apple);
            zorak.setBedrijf(apple);
            dinoos.setBedrijf(apple);*/

            repository.saveAll(
                    List.of(taartenBakken, nanobots, dinoos, n1, n2, n3, zorak, terminals, robots, optimalisatie)
            );


            BJ.setSubject(subjectRepository.findByName("nog niet beslist"));
            maxou.setSubject(subjectRepository.findByName("nog niet beslist"));
            toon.setSubject(subjectRepository.findByName("nog niet beslist"));
            matthieu.setSubject(subjectRepository.findByName("nog niet beslist"));
            geert.setSubject(subjectRepository.findByName("nog niet beslist"));
            dinos.setSubject(subjectRepository.findByName("nog niet beslist"));
            kurt.setSubject(subjectRepository.findByName("nog niet beslist"));
            dwight.setSubject(subjectRepository.findByName("nog niet beslist"));
            Kanye.setSubject(subjectRepository.findByName("nog niet beslist"));
            djef.setSubject(subjectRepository.findByName("nog niet beslist"));
            dirk.setSubject(subjectRepository.findByName("nog niet beslist"));
            zorakthegreat.setSubject(subjectRepository.findByName("nog niet beslist"));

            apple.setSubject(subjectRepository.findByName("nog niet beslist"));
            shady.setSubject(subjectRepository.findByName("nog niet beslist"));





            BJ.setOpleiding(opleidingsRepository.findByName("ELICT"));
            geert.setOpleiding(opleidingsRepository.findByName("ELICT"));
            dinos.setOpleiding(opleidingsRepository.findByName("ELICT"));
            kurt.setOpleiding(opleidingsRepository.findByName("ELICT"));
            dwight.setOpleiding(opleidingsRepository.findByName("ELICT"));
            Kanye.setOpleiding(opleidingsRepository.findByName("EM"));
            maxou.setOpleiding(opleidingsRepository.findByName("EM"));
            toon.setOpleiding(opleidingsRepository.findByName("EM"));
            matthieu.setOpleiding(opleidingsRepository.findByName("EM"));
            djef.setOpleiding(opleidingsRepository.findByName("EM"));
            dirk.setOpleiding(opleidingsRepository.findByName("EM"));

            zorakthegreat.setOpleiding(opleidingsRepository.findByName("ELICT"));

            apple.setOpleiding(opleidingsRepository.findByName("ELICT"));
            shady.setOpleiding(opleidingsRepository.findByName("ELICT"));



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
            dirk.setCampus(campusRepository.findByName("Aalst"));
            zorakthegreat.setCampus(campusRepository.findByName("Gent"));

            apple.setCampus(campusRepository.findByName("Gent"));
            shady.setCampus(campusRepository.findByName("Gent"));


            BJ.setGeboostVoor(Arrays.asList(subjectRepository.findByName("nog niet beslist")));
            maxou.setGeboostVoor(Arrays.asList(subjectRepository.findByName("nog niet beslist")));
            toon.setGeboostVoor(Arrays.asList(subjectRepository.findByName("nog niet beslist")));
            matthieu.setGeboostVoor(Arrays.asList(subjectRepository.findByName("nog niet beslist")));
            geert.setGeboostVoor(Arrays.asList(subjectRepository.findByName("nog niet beslist")));
            dinos.setGeboostVoor(Arrays.asList(subjectRepository.findByName("nog niet beslist")));
            kurt.setGeboostVoor(Arrays.asList(subjectRepository.findByName("nog niet beslist")));
            dwight.setGeboostVoor(Arrays.asList(subjectRepository.findByName("nog niet beslist")));
            Kanye.setGeboostVoor(Arrays.asList(subjectRepository.findByName("nog niet beslist")));
            djef.setGeboostVoor(Arrays.asList(subjectRepository.findByName("nog niet beslist")));
            dirk.setGeboostVoor(Arrays.asList(subjectRepository.findByName("nog niet beslist")));

            apple.setGeboostVoor(Arrays.asList(subjectRepository.findByName("nog niet beslist")));
            shady.setGeboostVoor(Arrays.asList(subjectRepository.findByName("nog niet beslist")));




            zorakthegreat.setGeboostVoor(Arrays.asList(subjectRepository.findByName("greatness")));


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

            dirk.setKeuze1(subjectRepository.findByName("nog niet beslist"));
            dirk.setKeuze2(subjectRepository.findByName("nog niet beslist"));
            dirk.setKeuze3(subjectRepository.findByName("nog niet beslist"));

            zorakthegreat.setKeuze1(subjectRepository.findByName("greatness"));
            zorakthegreat.setKeuze2(subjectRepository.findByName("nog niet beslist"));
            zorakthegreat.setKeuze3(subjectRepository.findByName("nog niet beslist"));

            apple.setKeuze1(subjectRepository.findByName("nog niet beslist"));
            apple.setKeuze2(subjectRepository.findByName("nog niet beslist"));
            apple.setKeuze3(subjectRepository.findByName("nog niet beslist"));

            shady.setKeuze1(subjectRepository.findByName("nog niet beslist"));
            shady.setKeuze2(subjectRepository.findByName("nog niet beslist"));
            shady.setKeuze3(subjectRepository.findByName("nog niet beslist"));


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
            try {
                userController.addNewPerson(zorakthegreat);
            } catch (EmailExists e) {
                e.printStackTrace();
            }
            try {
                userController.addNewPerson(apple);
            } catch (EmailExists e) {
                e.printStackTrace();
            }
            try {
                userController.addNewPerson(shady);
            } catch (EmailExists e) {
                e.printStackTrace();
            }
            try {
                userController.addNewPerson(dirk);
            } catch (EmailExists e) {
                e.printStackTrace();
            }

            //promotor enkel bij richting van onderwerp te zien!!!!!!!!!!!
            subjectService.changePromotor("zinsbouw", "djef@gmail.com");
            subjectService.changePromotor("zinnen", "djef@gmail.com");
            subjectService.changePromotor("werkwoorden", "djef@gmail.com");
            subjectService.changePromotor("greatness", "geert@gmail.com");


            subjectService.changePromotor("AI malware", "dirk@gmail.com");
            subjectService.changePromotor("optimalisatiesoftware", "dirk@gmail.com");

            userService.setSubject("greatness", "zorak@gmail.com");

            subjectService.verhooggekozen("greatness");


            subjectService.setBedrijf("zinsbouw", "apple@gmail.com");
            subjectService.setBedrijf("werkwoorden","apple@gmail.com");
            subjectService.setBedrijf("fortnite","apple@gmail.com");

        };
    }
}
