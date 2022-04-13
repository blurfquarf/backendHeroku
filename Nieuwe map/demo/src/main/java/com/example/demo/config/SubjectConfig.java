package com.example.demo.config;

import com.example.demo.models.Subject;
import com.example.demo.repository.SubjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
@Configuration
public class SubjectConfig {


    @Bean
    CommandLineRunner commandLineRunner2(SubjectRepository repository){
        return args -> {
            Subject taartenBakken = new Subject("Taarten bakken", "sssss", true);

            Subject nanobots = new Subject("vroemvroem");

            Subject dinos = new Subject("nog niet beslist");


            repository.saveAll(
                    List.of(taartenBakken, nanobots, dinos)
            );
        };
    }
}
