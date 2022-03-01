package com.example.demo.service;


import com.example.demo.models.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
@CrossOrigin(origins = "http://localhost:3000")
public class PromotorService {

    private final PromotorRepository promotorRepository;

    @Autowired
    public PromotorService(PromotorRepository promotorRepository) {
        this.promotorRepository = promotorRepository;
    }

    public List<Promotor> getPromotors(){
        return promotorRepository.findAll();
    }

    public void addNewPromotor(Promotor promotor) {
        promotorRepository.save(promotor);
    }


    public void deletePromotor(Long promotorId) {
        boolean exists = promotorRepository.existsById(promotorId);
        if(!exists){
            throw new IllegalStateException("student with id " + promotorId +
                    " does not exist");
        }
        promotorRepository.deleteById(promotorId);
    }

}
