package com.example.demo.config;

import com.example.demo.models.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student Boris = new Student("Boris");

            Student Gert = new Student("Gert");

            Student Tim = new Student("Tim");


            repository.saveAll(
                    List.of(Boris, Gert, Tim)
            );

        };
    }
}

