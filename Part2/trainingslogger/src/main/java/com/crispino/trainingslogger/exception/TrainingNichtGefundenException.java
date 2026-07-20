package com.crispino.trainingslogger.exception;

public class TrainingNichtGefundenException extends RuntimeException{
    public TrainingNichtGefundenException(int id){
        super("Training mit ID: " + id + " wurde nicht gefunden.");
    }
}
