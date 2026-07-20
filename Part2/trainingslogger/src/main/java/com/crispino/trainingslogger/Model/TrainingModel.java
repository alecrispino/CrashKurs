package com.crispino.trainingslogger.model;

public class TrainingModel {
    private int id;
    private String name;
    private int dauerInMinuten;
    private boolean sparring;

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

    public TrainingModel(String name, int dauerInMinuten, boolean sparring){
        if (dauerInMinuten <= 0) {
            throw new IllegalArgumentException("Dauer muss eine positive Zahl sein");
        }
        
        this.name = name;
        this.dauerInMinuten = dauerInMinuten;
        this.sparring = sparring;
    }

    @Override
    public String toString(){
        return "Name: " + this.name + " Dauer: " + this.dauerInMinuten + " ist Sparring: " + this.sparring;
    }
}