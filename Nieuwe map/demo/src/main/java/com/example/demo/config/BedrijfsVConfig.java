package com.example.demo.config;

import com.example.demo.models.BedrijfsVerantwoordelijke;
import com.example.demo.models.Coordinator;
import com.example.demo.models.Student;
import com.example.demo.repository.BedrijfsVRepository;
import com.example.demo.repository.CoordinatorRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BedrijfsVConfig {

    @Bean
    CommandLineRunner commandLineRunner4(BedrijfsVRepository repository){
        return args -> {
            BedrijfsVerantwoordelijke henk = new BedrijfsVerantwoordelijke("Henk", "apple");
            BedrijfsVerantwoordelijke Homk = new BedrijfsVerantwoordelijke("Homk", "apple");
            BedrijfsVerantwoordelijke Honk = new BedrijfsVerantwoordelijke("Honk", "apple");


            repository.saveAll(
                    List.of(henk, Homk, Honk)
            );

        };
    }
}
