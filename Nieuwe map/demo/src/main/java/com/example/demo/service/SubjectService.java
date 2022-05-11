package com.example.demo.service;


import com.example.demo.models.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@CrossOrigin(origins = "http://localhost:3000")
public class SubjectService {

    private SubjectRepository subjectRepository;
    private UserRepository userRepository;
    private CampusRepository campusRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository, UserRepository userRepository, CampusRepository campusRepository) {
        this.subjectRepository = subjectRepository;
        this.userRepository = userRepository;
        this.campusRepository = campusRepository;
    }

    public List<Subject> getSubjects() {
        List<Subject> all = subjectRepository.findAll();
        List<Subject> correct = new ArrayList<>();

        for(int i = 0; i < all.size(); i++){
            if (!all.get(i).getNietMeerBeschikbaar())  {
                correct.add(all.get(i));
            }
        }
        return correct;
    }

    public void addNewSubject(Subject subject) {
        subjectRepository.save(subject);
    }

    public void deleteSubject(Long studentId) {
        boolean exists = subjectRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("subject with id " + studentId +
                    " does not exist");
        }
        subjectRepository.deleteById(studentId);
    }

    public void changePromotor(String subjectName, String mail) {
        Subject s = subjectRepository.findByName(subjectName);
        s.setPromotor(userRepository.findByEmail(mail));
    }

    public void setCopros(List<String> copro, String subjectName) {
        Subject s = subjectRepository.findByName(subjectName);
        for (int i = 0; i < copro.size(); i++){
            User u = userRepository.findByEmail(copro.get(i));
            s.addToCopros(u);
        }
    }


    public void setApproved(String subjectName) {
        Subject s = subjectRepository.findByName(subjectName);
        s.setApproved();
        s.setReedsGoedgekeurd();
    }

    public void setCampus(List<String> campussen, String subject) {
        Subject s = subjectRepository.findByName(subject);
        for (int i = 0; i < campussen.size(); i++){
            Campus c = campusRepository.findByName(campussen.get(i));
            s.addToCampussen(c);
        }
    }

    public void setRGGK(String subjectName) {
        Subject s = subjectRepository.findByName(subjectName);
        s.setReedsGoedgekeurd();
    }

    public Subject getK1(String mail) {
        User u = userRepository.findByEmail(mail);
        return u.getKeuze1();
    }

    public Subject getK2(String mail) {
        User u = userRepository.findByEmail(mail);
        return u.getKeuze2();
    }
    public Subject getK3(String mail) {
        User u = userRepository.findByEmail(mail);
        return u.getKeuze3();
    }


    //subject per promotor
    public List<Subject> getSperPro(String mail){
        User promotor = userRepository.findByEmail(mail);
        List<Subject> subs = subjectRepository.findAll();
        List<Subject> perPromotor = new ArrayList<>();
        for(int i = 0; i < subs.size(); i ++){
            if(subs.get(i).getPromotor() == promotor){
                perPromotor.add(subs.get(i));
            }
        }
        return perPromotor;
    }

    public List<Subject> getTargetSubjects(String mail){
        User u = userRepository.findByEmail(mail);
        List<Subject> resultList = new ArrayList<>();
        List<Subject> allSubjects = subjectRepository.findAll();

        for (int i = 0; i < allSubjects.size(); i ++){
            if (allSubjects.get(i).getOpleidingen().contains(u.getOpleiding()) &&
                    allSubjects.get(i).getCampussen().contains(u.getCampus()) &&
                    !allSubjects.get(i).getNietMeerBeschikbaar()
            ){
                resultList.add(allSubjects.get(i));
            }
        }
        return resultList;
    }


    //vraag per onderwerp geboosten op
    public List<User> getBoosted(String subjectName) {
        List<User> users = userRepository.findAll();
        Subject s = subjectRepository.findByName(subjectName);
        List<User> boosted = new ArrayList<>();
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getGeboostVoor().contains(s)){
                boosted.add(users.get(i));
            }
        }
        return boosted;
    }
}
