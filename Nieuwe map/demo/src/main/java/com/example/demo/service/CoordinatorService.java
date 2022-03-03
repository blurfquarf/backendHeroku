package com.example.demo.service;


import com.example.demo.models.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
@CrossOrigin(origins = "http://localhost:3000")
public class CoordinatorService {

    private final CoordinatorRepository coordinatorRepository;

    @Autowired
    public CoordinatorService(CoordinatorRepository coordinatorRepository) {
        this.coordinatorRepository = coordinatorRepository;
    }

    public List<Coordinator> getCoordinators(){
        return coordinatorRepository.findAll();
    }

    public void addNewCoordinator(Coordinator coordinator) {
        coordinatorRepository.save(coordinator);
    }


    public void deleteCoordinator(Long coordinatorId) {
        boolean exists = coordinatorRepository.existsById(coordinatorId);
        if(!exists){
            throw new IllegalStateException("coordinator with id " + coordinatorId +
                    " does not exist");
        }
        coordinatorRepository.deleteById(coordinatorId);
    }

}
