package com.example.demo.config;

import com.example.demo.models.Promotor;
import com.example.demo.repository.PromotorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PromotorConfig {

    @Bean
    CommandLineRunner commandLineRunner2(PromotorRepository repository){
        return args -> {

            Promotor dieter = new Promotor("Dieter");

            Promotor dirk = new Promotor("Dirk");

            Promotor rik = new Promotor("Rik");

            repository.saveAll(
                    List.of(dieter, dirk, rik)
            );
        };
    }
}
