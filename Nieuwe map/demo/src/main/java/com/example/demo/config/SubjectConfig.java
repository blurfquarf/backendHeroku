package com.example.demo.config;

import com.example.demo.models.Campus;
import com.example.demo.models.Subject;
import com.example.demo.repository.CampusRepository;
import com.example.demo.repository.OpleidingsRepository;
import com.example.demo.repository.SubjectRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;
@Configuration
public class SubjectConfig {

    @Bean
    CommandLineRunner commandLineRunner2(SubjectRepository repository, UserRepository userRepository,
                                         CampusRepository campusRepository, OpleidingsRepository opleidingsRepository){
        return args -> {

            Campus G = new Campus("Gent");
            Campus B = new Campus("Brugge");

            campusRepository.saveAll(List.of(G, B));



            Subject taartenBakken = new Subject("Taarten bakken", "sssss", true);

            Subject nanobots = new Subject("vroemvroem");

            Subject dinos = new Subject("nog niet beslist");

            dinos.addToCampussen(campusRepository.findByName("Gent"));
            dinos.addToCampussen(campusRepository.findByName("Brugge"));


/*

            dinos.setOpleidingen(Arrays.asList(opleidingsRepository.findByName("ELICT")));

*/

            taartenBakken.setReedsGoedgekeurd();
/*

            taartenBakken.setPromotor(userRepository.findByUsername("GeertGoossens"));
            nanobots.setPromotor(userRepository.findByUsername("GeertGoossens"));
            dinos.setPromotor(userRepository.findByUsername("GeertGoossens"));
*/



            repository.saveAll(
                    List.of(taartenBakken, nanobots, dinos)
            );
        };
    }
}
