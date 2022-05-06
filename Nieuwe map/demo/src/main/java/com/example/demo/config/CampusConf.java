/*
package com.example.demo.config;

import com.example.demo.models.Campus;
import com.example.demo.repository.CampusRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CampusConf {

    @Bean
    CommandLineRunner commandLineRunner4(CampusRepository campusRepository){
        return args -> {

            Campus G = new Campus("Gent");
            Campus B = new Campus("Brugge");

            campusRepository.saveAll(List.of(G, B));

        };
    }
}*/
