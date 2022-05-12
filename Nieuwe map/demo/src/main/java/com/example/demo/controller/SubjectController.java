package com.example.demo.controller;

import com.example.demo.models.*;
import com.example.demo.service.*;
import org.hibernate.boot.jaxb.hbm.spi.SubEntityInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/subject")
public class SubjectController {

    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService){
        this.subjectService = subjectService;
    }

    @CrossOrigin(origins = "https://localhost:3000")
    @GetMapping
    public List<Subject> getSubject(){
        return subjectService.getSubjects();
    }

    @CrossOrigin(origins = "https://localhost:3000", allowedHeaders = "*")
    @PostMapping
    public void registerNewSubject(@RequestBody Subject subject){
        subjectService.addNewSubject(subject);
    }

    @DeleteMapping("{subjectId}")
    @CrossOrigin(origins = "https://localhost:3000")
    public void deleteSubject(@PathVariable("subjectId") Long subjectId){
        subjectService.deleteSubject(subjectId);
    }

    @PostMapping("/pro")
    @CrossOrigin(origins = "https://localhost:3000", allowedHeaders = "*")
    public void promotor(@RequestParam String subjectName, @RequestParam String mail){
        subjectService.changePromotor(subjectName, mail);
    }

    @PostMapping("/copro")
    @CrossOrigin(origins = "https://localhost:3000", allowedHeaders = "*")
    public void copromotoren(@RequestParam List<String> copromail, @RequestParam String subjectName){
        subjectService.setCopros(copromail, subjectName);
    }

    @PostMapping("/approved")
    @CrossOrigin(origins = "https://localhost:3000", allowedHeaders = "*")
    public void approved(@RequestParam String subjectName){
        subjectService.setApproved(subjectName);
    }

    @PostMapping("/campus")
    @CrossOrigin(origins = "https://localhost:3000", allowedHeaders = "*")
    public void campus(@RequestParam List<String> campussen, @RequestParam String subject){
        subjectService.setCampus(campussen, subject);
    }

    @PostMapping("/reedsgoedgekeurd")
    @CrossOrigin(origins = "https://localhost:3000", allowedHeaders = "*")
    public void reedsGGK(@RequestParam String subjectName){
        subjectService.setRGGK(subjectName);
    }

    @GetMapping(value = "/keuze1")
    @CrossOrigin(origins = "https://localhost:3000", allowedHeaders = "*")
    public Subject getKeuze1(@RequestParam  String mail) {
        return subjectService.getK1(mail);
    }

    @GetMapping(value = "/keuze2")
    @CrossOrigin(origins = "https://localhost:3000", allowedHeaders = "*")
    public Subject getKeuze2(@RequestParam String mail) {
        return subjectService.getK2(mail);
    }

    @GetMapping(value = "/keuze3")
    @CrossOrigin(origins = "https://localhost:3000", allowedHeaders = "*")
    public Subject getKeuze3(@RequestParam String mail) {
        return subjectService.getK3(mail);
    }



    //per promotor alle subjects
    @GetMapping(value = "/subjectsprom")
    @CrossOrigin(origins = "https://localhost:3000", allowedHeaders = "*")
    public List<Subject> getSperPro(@RequestParam String mail) {
        return subjectService.getSperPro(mail);
    }




    @GetMapping(value = "/targetsubjects")
    @CrossOrigin(origins = "https://localhost:3000", allowedHeaders = "*")
    public List<Subject> getTargetSubjects(@RequestParam String mail){
        return subjectService.getTargetSubjects(mail);
    }



    @GetMapping(value = "/boostperonderwerp")
    @CrossOrigin(origins = "https://localhost:3000", allowedHeaders = "*")
    public List<User> getBoosted(@RequestParam String subjectName){
        return subjectService.getBoosted(subjectName);
    }




    @GetMapping(value = "/subjectdetails")
    @CrossOrigin(origins = "https://localhost:3000", allowedHeaders = "*")
    public List<Subject> getOneSubject(@RequestParam String subjectName){
        return subjectService.getOneSubject(subjectName);
    }

    @GetMapping(value = "/bedrijven")
    @CrossOrigin(origins = "https://localhost:3000", allowedHeaders = "*")
    public List<User> getBedrijven(){
        return subjectService.getBedrijven();
    }




    //onderwerpen voor 1 bedrijf
    @GetMapping(value = "/onderwerpperbedrijf")
    @CrossOrigin(origins = "https://localhost:3000", allowedHeaders = "*")
    public List<Subject> getBedrijfSubjects(@RequestParam String mail){
        return subjectService.getBedrijfSubjects(mail);
    }




}
