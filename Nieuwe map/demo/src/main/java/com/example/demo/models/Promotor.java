package com.example.demo.models;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@CrossOrigin(origins = "http://localhost:3000")
public class Promotor extends Person{

    @OneToMany(mappedBy = "promotor")
    private List<Subject> subject;

    public Promotor() {
    }

    public Promotor(String name) {
        super(name);
    }

    public Promotor(long id) {
        super(id);
    }

    public Promotor(long id, String name) {
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
        return "Promotor{" +
                "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                '}';
    }
}
