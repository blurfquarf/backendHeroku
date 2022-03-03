package com.example.demo.controller;

import com.example.demo.models.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/coordinator")
public class CoordinatorController {

    private final CoordinatorService coordinatorService;

    @Autowired
    public CoordinatorController(CoordinatorService cs){
        this.coordinatorService = cs;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public List<Coordinator> getPromotors(){
        return coordinatorService.getCoordinators();
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public void registerNewPromotor(@RequestBody Coordinator coordinator){
        coordinatorService.addNewCoordinator(coordinator);
    }

    @DeleteMapping("{coordinatorId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public void deletePromotor(@PathVariable("coordinatorId") Long coordinatorId){
        coordinatorService.deleteCoordinator(coordinatorId);
    }


}
