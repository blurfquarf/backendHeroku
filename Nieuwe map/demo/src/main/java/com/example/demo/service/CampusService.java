package com.example.demo.service;


import com.example.demo.models.Campus;
import com.example.demo.models.Role;
import com.example.demo.repository.CampusRepository;
import com.example.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
@CrossOrigin(origins = "https://localhost:3000")
public class CampusService {

    private CampusRepository campusRepository;



    @Autowired
    public CampusService(CampusRepository campusRepository) {
        this.campusRepository = campusRepository;
    }


    public List<Campus> getCampussen(){
        return campusRepository.findAll();
    }


}
