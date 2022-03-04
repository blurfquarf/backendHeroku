package com.example.demo.models;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;


@Entity
@Table
@CrossOrigin(origins = "http://localhost:3000")
public class Coordinator extends Person{
    public Coordinator(){

    }

    public Coordinator(String name){
        super(name);
    }

    public Coordinator(long id){
        super(id);
    }

    public Coordinator(long id, String name){
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
        return "Coordinator{" +
                "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                '}';
    }

}
