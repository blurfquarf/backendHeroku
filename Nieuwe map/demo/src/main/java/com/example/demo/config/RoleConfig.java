package com.example.demo.config;

import com.example.demo.models.ERole;
import com.example.demo.models.Role;
import com.example.demo.models.Subject;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.SubjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
@Configuration
public class RoleConfig {

    @Bean
    CommandLineRunner commandLineRunner3(RoleRepository roleRepository){
        return args -> {

            Role studentRole = new Role("ROLE_STUDENT");
            Role promotorRole = new Role("ROLE_PROMOTOR");
            Role coordinatorRole = new Role("ROLE_COORDINATOR");
            Role bedrijfsV = new Role("ROLE_BEDRIJF");
            //Role admin = new Role("ROLE_ADMIN");

            roleRepository.saveAll(List.of(studentRole, promotorRole, coordinatorRole, bedrijfsV));
        };
    }
}











