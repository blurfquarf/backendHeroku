package com.example.demo.models;

import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.util.*;

@Entity
@Table
@CrossOrigin(origins = "http://localhost:3000")
public class Subject {
    @Id
    @SequenceGenerator(
            name = "subject_sequence",
            sequenceName = "subject_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "subject_sequence"
    )

    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "subject")
    private List<Student> student;

    @ManyToOne
    @JoinColumn(name = "promotor_id")
    private Promotor promotor;

    @ManyToOne
    @JoinColumn(name = "bedrijfsV_id")
    private BedrijfsVerantwoordelijke bedrijfsV;

    public BedrijfsVerantwoordelijke getBedrijfsV() {return bedrijfsV;}

    public Promotor getPromotor() {
        return promotor;
    }

    public List<Student> getStudents() {
        return student;
    }

    public Subject(String n) {
        name = n;
    }

    public Subject(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Subject(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Subject() {

    }

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

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name=" + name + ", description" + '\'' +
                '}';
    }
    public void setStudent(Student s){
        if (!student.contains(s)){
            //is er nog plaats voor deze student?
            if (student.isEmpty()||student.size()==1){
                student.add(s);
                s.setSubject(this);
            }
            //kunnen we gebruiken om met een commando de link tussen subject en studenten
            // te verwijderen ipv aparte methode
            else if (s==null){
                List<Student> tmpStudent = student;
                student = null;
                ListIterator<Student> itr = tmpStudent.listIterator();
                while(itr.hasNext()) itr.next().setSubject(null);
            }
            /*else {
                //methode zou de oude leerling overschrijven indien er toch inzitten,
                //nog geen implementatie voor kunnen bedenken :p
                //zou hier graag fout opwerpen, maar weet nog niet hoe
                ListIterator<Student> itr = student.listIterator();
                while(itr.hasNext()) itr.next().setSubject(null);
                s.setSubject(null);
                setStudent(s);
            }*/
        }

    }
    public void setPromotor(Promotor p){
        if (promotor!=p){

            if (promotor==null){
                promotor=p;
                p.setSubject(this);
            }
            else if (p==null){
                Promotor tmpPromotor = promotor;
                promotor = null;
                tmpPromotor.setSubject(null);
            }
            /*else {
                promotor.setSubject(null);
                s.setSubject(null);
                setPromotor(s);
            }*/
        }
    }
    public void setBedrijfsV(BedrijfsVerantwoordelijke bv){
        if (bedrijfsV!=bv){

            if (bedrijfsV==null){
                bedrijfsV=bv;
                bv.setSubject(this);
            }
            else if (bv==null){
                BedrijfsVerantwoordelijke tmpBedrijfsV = bedrijfsV;
                bedrijfsV = null;
                tmpBedrijfsV.setSubject(null);
            }
            /*else {
                bedrijfsV.setSubject(null);
                s.setBedrijfsV(null);
                setBedrijfsV(s);
            }*/
        }
    }
}
