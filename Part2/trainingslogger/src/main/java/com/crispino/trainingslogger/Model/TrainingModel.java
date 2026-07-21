package com.crispino.trainingslogger.model;

import java.util.List;
import java.util.ArrayList;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class TrainingModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int dauerInMinuten;
    private boolean sparring;

    @OneToMany(mappedBy = "training", cascade = CascadeType.ALL)
    private List<Uebung> uebungen = new ArrayList<>();

    protected TrainingModel(){}

    public TrainingModel(String name, int dauerInMinuten, boolean sparring){
        if (dauerInMinuten <= 0) {
            throw new IllegalArgumentException("Dauer muss eine positive Zahl sein");
        }
        
        this.name = name;
        this.dauerInMinuten = dauerInMinuten;
        this.sparring = sparring;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public int getDauerInMinuten(){
        return this.dauerInMinuten;
    }

    public boolean isSparring(){
        return this.sparring;
    }

    @Override
    public String toString(){
        return "Name: " + this.name + " Dauer: " + this.dauerInMinuten + " ist Sparring: " + this.sparring;
    }

    public void addUebung(Uebung uebung){
        uebungen.add(uebung);
        uebung.setTraining(this);
    }
}