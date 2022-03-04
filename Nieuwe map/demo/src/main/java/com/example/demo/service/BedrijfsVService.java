package com.example.demo.service;


import com.example.demo.models.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
@CrossOrigin(origins = "http://localhost:3000")
public class BedrijfsVService {

    private final BedrijfsVRepository bedrijfsVRepository;

    @Autowired
    public BedrijfsVService(BedrijfsVRepository bedrijfsVRepository) {
        this.bedrijfsVRepository = bedrijfsVRepository;
    }

    public List<Coordinator> getBedrijfsV(){
        return bedrijfsVRepository.findAll();
    }

    public void addNewBedrijfsV(Coordinator coordinator) {
        bedrijfsVRepository.save(coordinator);
    }


    public void deleteBedrijfsV(Long bedrijfsVId) {
        boolean exists = bedrijfsVRepository.existsById(bedrijfsVId);
        if(!exists){
            throw new IllegalStateException("bedrijfsV with id " + bedrijfsVId +
                    " does not exist");
        }
        bedrijfsVRepository.deleteById(bedrijfsVId);
    }

}
