package com.example.demo.models;

import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;

@Entity
@Table
@CrossOrigin(origins = "http://localhost:3000")
public class Student extends Person {



    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    public Subject getSubject() {
        return subject;
    }

    public Student() {
    }

    public Student(long id, String name) {
        super(id, name);
    }

    public Student(String name) {
        super(name);
    }

    public long getId() {
        return super.getId();
    }

    public void setId(long id) {
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
        return "Student{" +
                "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                '}';
    }
    //documentatie analoog aan setStudent in Subject.java
    public void setSubject(Subject s){
        if (subject!=s){

            if (subject==null){
                subject=s;
                s.setStudent(this);
            }
            else if (s==null){
                Subject tmpSubject = subject;
                subject = null;
                tmpSubject.setStudent(null);
            }
            /*else {
                subject.setStudent(null);
                s.setStudent(null);
                setSubject(s);
            }*/
        }
    }
}
