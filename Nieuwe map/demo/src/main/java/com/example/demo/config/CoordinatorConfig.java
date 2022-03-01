package com.example.demo.config;

import com.example.demo.models.Coordinator;
import com.example.demo.models.Student;
import com.example.demo.repository.CoordinatorRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CoordinatorConfig {

    @Bean
    CommandLineRunner commandLineRunner3(CoordinatorRepository repository){
        return args -> {
            Coordinator henk = new Coordinator("Henk");

            Coordinator diedriek = new Coordinator("Diedriek");

            Coordinator francis = new Coordinator("Francic");

            repository.saveAll(
                    List.of(henk, diedriek, francis)
            );

        };
    }
}
