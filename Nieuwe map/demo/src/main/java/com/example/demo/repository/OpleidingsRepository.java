package com.example.demo.repository;

import com.example.demo.models.Opleiding;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpleidingsRepository extends JpaRepository<Opleiding, Long> {

    Opleiding findByName(String name);

    @Override
    void delete(Opleiding opleiding);
}