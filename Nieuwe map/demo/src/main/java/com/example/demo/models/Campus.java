package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table
public class Campus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    public Campus(String n){
        this.name = n;
    }

    public Campus() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
