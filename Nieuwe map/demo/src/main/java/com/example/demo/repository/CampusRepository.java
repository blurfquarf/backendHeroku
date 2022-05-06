package com.example.demo.repository;

import com.example.demo.models.Campus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampusRepository extends JpaRepository<Campus, Long> {

    Campus findByName(String name);

    @Override
    void delete(Campus campus);

}