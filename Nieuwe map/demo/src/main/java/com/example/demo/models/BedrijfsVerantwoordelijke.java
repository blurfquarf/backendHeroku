package com.example.demo.models;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;


@Entity
@Table
@CrossOrigin(origins = "http://localhost:3000")
public class BedrijfsVerantwoordelijke extends Person{

    private String bedrijf;


    public BedrijfsVerantwoordelijke(){

    }

    public BedrijfsVerantwoordelijke(String name, String bedrijf){
        super(name);
        this.bedrijf = bedrijf;
    }

    public BedrijfsVerantwoordelijke(long id){
        super(id);
    }

    public BedrijfsVerantwoordelijke(long id, String name, String bedrijf){
        super(id, name);
        this.bedrijf = bedrijf;
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

    public String getBedrijf() {
        return  bedrijf;
    }




    @Override
    public String toString() {
        return "Bedrijfsverantwoordelijke{" +
                "id=" + super.getId() +
                ", name='" + super.getName() + ", bedrijf=" + bedrijf + '\'' +
                '}';
    }



}
