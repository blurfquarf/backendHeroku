package com.example.demo.repository;


import com.example.demo.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //hoe opgeslagen in databank
public interface BedrijfsVRepository extends
        JpaRepository<BedrijfsVerantwoordelijke, Long> {

}
