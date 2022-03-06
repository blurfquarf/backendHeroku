package com.example.demo.models;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.util.List;
import java.util.ListIterator;


@Entity
@Table
@CrossOrigin(origins = "http://localhost:3000")
public class BedrijfsVerantwoordelijke extends Person{


    private String bedrijf;

    @OneToMany(mappedBy = "bedrijfsV")
    private List<Subject> subject;

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
        return bedrijf;
    }




    @Override
    public String toString() {
        return "Bedrijfsverantwoordelijke{" +
                "id=" + super.getId() +
                ", name='" + super.getName() + ", bedrijf=" + bedrijf + '\'' +
                '}';
    }

    public void setSubject(Subject s) {
        if (!subject.contains(s)) {
            //is er nog plaats voor deze student?
            if (subject.isEmpty() || subject.size() == 1) {
                subject.add(s);
                s.setBedrijfsV(this);
            }
            //kunnen we gebruiken om met een commando de link tussen subject en studenten
            // te verwijderen ipv aparte methode
            else if (s == null) {
                List<Subject> tmpSubject = subject;
                subject = null;
                ListIterator<Subject> itr = tmpSubject.listIterator();
                while (itr.hasNext()) itr.next().setBedrijfsV(null);
            }
            /*else {
                //methode zou de oude leerling overschrijven indien er toch inzitten,
                //nog geen implementatie voor kunnen bedenken :p
                //zou hier graag fout opwerpen, maar weet nog niet hoe
                ListIterator<Subject> itr = subject.listIterator();
                while(itr.hasNext()) itr.next().setBedrijfsV(null);
                s.setPromotor(null);
                setSubject(s);
            }*/
        }
    }

}
