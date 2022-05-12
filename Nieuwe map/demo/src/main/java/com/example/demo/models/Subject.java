package com.example.demo.models;

import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.util.*;

@Entity
@Table
@CrossOrigin(origins = "https://localhost:3000")
public class Subject {
    @Id
    @Column(unique = true, nullable = false)
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

    private boolean reedsGoedgekeurd;



    public void setBedrijf(User bedrijf) {
        this.bedrijf = bedrijf;
    }

    @ManyToOne
    @JoinColumn(name = "bedrijf_id")
    private User bedrijf;






    private Integer gekozen = 0;

    public Integer getGekozen() {
        return gekozen;
    }



    public void setGekozen(Integer gekozen) {
        this.gekozen = gekozen;
    }
    public void gekozen() {
        this.gekozen++;
    }




    public void setNietMeerBeschikbaar(){
        nietMeerBeschikbaar = true;
    }

    public boolean getNietMeerBeschikbaar(){
        return nietMeerBeschikbaar;
    }

    private boolean nietMeerBeschikbaar;

    public List<Opleiding> getOpleidingen() {
        return opleidingen;
    }

    public void setOpleidingen(List<Opleiding> opleidingen) {
        this.opleidingen = opleidingen;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "subject_opleiding",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "opleiding_id"))
    private List<Opleiding> opleidingen = new ArrayList<Opleiding>();

    public List<Campus> getCampussen() {
        return campussen;
    }

    public void setCampussen(List<Campus> campussen) {
        this.campussen = campussen;
    }

    public void addToCampussen(Campus campus) {
        campussen.add(campus);
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "campus_subject",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "campus_id"))
    private List<Campus> campussen = new ArrayList<Campus>();


    public List<User> getCopromotoren() {
        return copromotoren;
    }

    public void setCopromotoren(List<User> copromotoren) {
        this.copromotoren = copromotoren;
    }

    public void addToCopros(User u){
        copromotoren.add(u);
    }


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "copromotor_subj",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> copromotoren = new ArrayList<User>();


    @ManyToOne
    @JoinColumn(name = "promotor")
    private User promotor;
    private boolean approved;

    public User getBedrijf() {
        return bedrijf;
    }

    public Subject(String n) {
        name = n;
    }

    public Subject(Long id, String name, String description, boolean approved) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.approved = false;
    }

    public Subject(String name, String description,
                   List<Campus> campussen, List<User> copromotoren, User bedrijf,
                   User promotor) {
        this.name = name;
        this.description = description;
        this.approved = false;
        this.campussen = campussen;
        this.reedsGoedgekeurd = false;
        this.copromotoren = copromotoren;
        this.bedrijf = bedrijf;
        this.promotor = promotor;
    }

    public Subject(String name, String description, boolean approved) {
        this.name = name;
        this.description = description;
        this.approved = approved;
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

    public boolean getApproved(){
        return approved;
    }

    public void setApproved(){
        approved = true;
    }

    public void setPromotor(User promotor){
        this.promotor = promotor;
    }

    public User getPromotor(){
        return promotor;
    }

/*    public List<User> getPromotor() {
        return promotoren;
    }
    public void setPromotoren(List<User> promotoren){this.promotoren = promotoren;}*/
    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", title=" + name + ", description" + '\'' +
                '}';
    }

    public boolean getReedsGoedgekeurd() {
        return reedsGoedgekeurd;
    }

    public void setReedsGoedgekeurd() {
        reedsGoedgekeurd = true;
        approved = true;
    }
}