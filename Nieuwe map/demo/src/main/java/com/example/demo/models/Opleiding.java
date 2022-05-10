package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.util.*;


@Entity
@CrossOrigin(origins = "https://localhost:3000")
public class Opleiding {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;

/*    @ManyToOne
    @JoinColumn(name = "coordinator_id")
    private User coordinator;

    public User getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(User user) {
        this.coordinator = user;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Opleiding(){
    }

    public Opleiding(String name){
        this.name = name;
    }
}
