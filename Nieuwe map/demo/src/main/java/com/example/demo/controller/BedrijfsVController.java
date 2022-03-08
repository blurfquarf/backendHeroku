package com.example.demo.controller;

import com.example.demo.models.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/bedrijfsV")
public class BedrijfsVController {

    private final BedrijfsVService bedrijfsVService;

    @Autowired
    public BedrijfsVController(BedrijfsVService bs){
        this.bedrijfsVService = bs;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public List<BedrijfsVerantwoordelijke> getBedrijfsV(){
        return bedrijfsVService.getBedrijfsV();
    }




    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public void registerNewBedrijfsV(@RequestBody BedrijfsVerantwoordelijke bedrijfsV){
        bedrijfsVService.addNewBedrijfsV(bedrijfsV);
    }






    @DeleteMapping("{bedrijfsVId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public void deleteBedrijfsV(@PathVariable("bedrijfsVId") Long bedrijfsVId){
        bedrijfsVService.deleteBedrijfsV(bedrijfsVId);
    }



}
