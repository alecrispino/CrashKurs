package com.crispino.trainingslogger.Model;

public class TrainingModel {
    private String name;
    private int dauerInMinuten;
    private boolean istSparring;

    public String getName(){
        return this.name;
    }

    public int getDauerInMinuten(){
        return this.dauerInMinuten;
    }

    public boolean isSparring(){
        return this.istSparring;
    }

    public TrainingModel(String name, int dauerInMinuten, boolean istSparring){
        if (dauerInMinuten <= 0) {
            throw new IllegalArgumentException("Dauer muss eine positive Zahl sein");
        }
        
        this.name = name;
        this.dauerInMinuten = dauerInMinuten;
        this.istSparring = istSparring;
    }

    @Override
    public String toString(){
        return "Name: " + this.name + " Dauer: " + this.dauerInMinuten + " ist Sparring: " + this.istSparring;
    }
}