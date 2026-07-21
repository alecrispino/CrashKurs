package com.crispino.trainingslogger.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Uebung {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String bezeichung;
    private int runden;

    @ManyToOne
    private TrainingModel training;

    protected Uebung(){}

    public Uebung(String bezeichung, int runden){
        this.bezeichung = bezeichung;
        this.runden = runden;
    }

    public int getId(){
        return this.id;
    }

    public String getBezeichnung(){
        return this.bezeichung;
    }

    public int getRunden(){
        return this.runden;
    }

    public TrainingModel getTraining(){
        return this.training;
    }

    public void setTraining(TrainingModel tm){
        this.training = tm;
    }
}
