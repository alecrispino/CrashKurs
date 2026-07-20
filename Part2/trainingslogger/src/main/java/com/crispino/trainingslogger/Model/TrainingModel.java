package com.crispino.trainingslogger.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TrainingModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int dauerInMinuten;
    private boolean sparring;

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
}