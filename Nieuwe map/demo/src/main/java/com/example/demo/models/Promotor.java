package com.example.demo.models;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.util.List;
import java.util.ListIterator;

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
    public void setSubject(Subject s) {
        if (!subject.contains(s)) {
            //is er nog plaats voor deze student?
            if (subject.isEmpty() || subject.size() == 1) {
                subject.add(s);
                s.setPromotor(this);
            }
            //kunnen we gebruiken om met een commando de link tussen subject en studenten
            // te verwijderen ipv aparte methode
            else if (s == null) {
                List<Subject> tmpSubject = subject;
                subject = null;
                ListIterator<Subject> itr = tmpSubject.listIterator();
                while (itr.hasNext()) itr.next().setPromotor(null);
            }
            /*else {
                //methode zou de oude leerling overschrijven indien er toch inzitten,
                //nog geen implementatie voor kunnen bedenken :p
                //zou hier graag fout opwerpen, maar weet nog niet hoe
                ListIterator<Subject> itr = subject.listIterator();
                while(itr.hasNext()) itr.next().setPromotor(null);
                s.setPromotor(null);
                setSubject(s);
            }*/
        }
    }
}
