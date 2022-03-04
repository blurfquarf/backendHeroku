package com.example.demo.models;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;


@Entity
@Table
@CrossOrigin(origins = "http://localhost:3000")
public class BedrijfsVerantwoordelijke extends Person{
    public BedrijfsVerantwoordelijke(){

    }

    public BedrijfsVerantwoordelijke(String name){
        super(name);
    }

    public BedrijfsVerantwoordelijke(long id){
        super(id);
    }

    public BedrijfsVerantwoordelijke(long id, String name){
        super(id, name);
    }

    public long getId() {
        return super.getId();
    }

    public void setId(Long id) {
        super.setId(id);
    }

    public String getName() {
        return super.getName();
    }

    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String toString() {
        return "Bedrijfsverantwoordelijke{" +
                "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                '}';
    }



}
