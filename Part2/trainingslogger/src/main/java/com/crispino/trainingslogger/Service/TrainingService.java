package com.crispino.trainingslogger.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.crispino.trainingslogger.Model.TrainingModel;

import java.util.ArrayList;

@Service
public class TrainingService {
    private List<TrainingModel> trainings = new ArrayList<>();

    public TrainingService(){
        this.trainings.add(new TrainingModel("Sparring", 45, true));
        this.trainings.add(new TrainingModel("Padwork", 60, false));
        this.trainings.add(new TrainingModel("Drills", 30, false));
        this.trainings.add(new TrainingModel("Sparring", 45, true));
    }
        
    public void hinzufuegen(TrainingModel t){
        trainings.add(t);
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

    public List<TrainingModel> alle(){
        return trainings;
    }
}    