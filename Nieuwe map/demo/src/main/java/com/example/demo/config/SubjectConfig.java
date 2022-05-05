package com.example.demo.config;

import com.example.demo.models.Subject;
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
    CommandLineRunner commandLineRunner2(SubjectRepository repository, UserRepository userRepository){
        return args -> {
            Subject taartenBakken = new Subject("Taarten bakken", "sssss", true);

            Subject nanobots = new Subject("vroemvroem");

            Subject dinos = new Subject("nog niet beslist");

            dinos.setCampus("Gent");

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
