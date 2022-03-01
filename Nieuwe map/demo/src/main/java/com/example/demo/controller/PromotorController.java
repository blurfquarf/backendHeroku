package com.example.demo.controller;

import com.example.demo.models.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/promotor")
public class PromotorController {

    private final PromotorService promotorService;

    @Autowired
    public PromotorController(PromotorService ps){
        this.promotorService = ps;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public List<Promotor> getPromotors(){
        return promotorService.getPromotors();
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public void registerNewPromotor(@RequestBody Promotor promotor){
        promotorService.addNewPromotor(promotor);
    }

    @DeleteMapping("{promotorId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public void deletePromotor(@PathVariable("promotorId") Long promotorId){
        promotorService.deletePromotor(promotorId);
    }


}
