package com.example.demo.controller;

import com.example.demo.models.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/coordinator")
public class BedrijfsVController {

    private final BedrijfsVService bedrijfsVServiceService;

    @Autowired
    public BedrijfsVController(BedrijfsVService bs){
        this.BedrijfsVService = bs;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public List<BedrijfsVerantwoordelijke> getBedrijfsV(){
        return BedrijfsVService.getCoordinators();
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
