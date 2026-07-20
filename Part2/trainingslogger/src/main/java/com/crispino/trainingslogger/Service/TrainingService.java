package com.crispino.trainingslogger.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.crispino.trainingslogger.exception.TrainingNichtGefundenException;
import com.crispino.trainingslogger.model.TrainingModel;

import java.util.ArrayList;

@Service
public class TrainingService {
    private List<TrainingModel> trainings = new ArrayList<>();
    private int naechsteId = 1;

    public TrainingService(){
        hinzufuegen(new TrainingModel("Sparring", 45, true));
        hinzufuegen(new TrainingModel("Padwork", 60, false));
        hinzufuegen(new TrainingModel("Drills", 30, false));
        hinzufuegen(new TrainingModel("Sparring", 45, true));
    }
        
    public TrainingModel hinzufuegen(TrainingModel t){
        t.setId(naechsteId);
        naechsteId++;
        trainings.add(t);
        return t;
    }

    public List<TrainingModel> nurSparring(){
        return trainings.stream()
                    .filter(t -> t.isSparring())
                    .toList();
    }

    public Integer gesamtMinuten(){
        return trainings.stream()
                    .mapToInt(t -> t.getDauerInMinuten())
                    .sum();
    }

    public Optional<TrainingModel> findeNachName(String name){
        return trainings.stream()
                    .filter(t -> t.getName().equals(name))
                    .findFirst();
    }

    public void deleteTraining(int id){
        if(!trainings.removeIf(t -> t.getId() == id)){
            throw new TrainingNichtGefundenException(id);
        }
    }

    public TrainingModel update(int id, TrainingModel tm){
        TrainingModel vorhanden = trainings.stream()
                                        .filter(t -> t.getId() == id)
                                        .findFirst()
                                        .orElseThrow(() -> new TrainingNichtGefundenException(id));

        int index = trainings.indexOf(vorhanden);
        tm.setId(id);
        trainings.set(index, tm);
        return tm;
    }

    public List<TrainingModel> alle(){
        return trainings;
    }
}    