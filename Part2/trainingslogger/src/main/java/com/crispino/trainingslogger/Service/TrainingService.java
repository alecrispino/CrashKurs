package com.crispino.trainingslogger.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.crispino.trainingslogger.exception.TrainingNichtGefundenException;
import com.crispino.trainingslogger.model.TrainingModel;
import com.crispino.trainingslogger.repository.TrainingRepository;

@Service
public class TrainingService {
    /*private List<TrainingModel> trainings = new ArrayList<>();
    private int naechsteId = 1;

    public TrainingService(){
        hinzufuegen(new TrainingModel("Sparring", 45, true));
        hinzufuegen(new TrainingModel("Padwork", 60, false));
        hinzufuegen(new TrainingModel("Drills", 30, false));
        hinzufuegen(new TrainingModel("Sparring", 45, true));
    }*/

    //JPA Repository implementation
    private final TrainingRepository trainingRepository;

    public TrainingService(TrainingRepository trainingRepository){
        this.trainingRepository = trainingRepository;
    }
        
    public TrainingModel hinzufuegen(TrainingModel t){
        /*t.setId(naechsteId);
        naechsteId++;
        trainings.add(t);
        return t;*/
        t.setId(0);
        return trainingRepository.save(t);
    }

    public List<TrainingModel> nurSparring(){
        /*return trainings.stream()
                    .filter(t -> t.isSparring())
                    .toList();
        */
        return trainingRepository.findAll().stream()
                    .filter(t -> t.isSparring())
                    .toList();
    }

    public Integer gesamtMinuten(){
        /*return trainings.stream()
                    .mapToInt(t -> t.getDauerInMinuten())
                    .sum();
        */
        return trainingRepository.findAll().stream()
                    .mapToInt(t -> t.getDauerInMinuten())
                    .sum();
    }

    public Optional<TrainingModel> findeNachName(String name){
        /*return trainings.stream()
                    .filter(t -> t.getName().equals(name))
                    .findFirst();
        */
        
        return trainingRepository.findAll().stream()
                    .filter(t -> t.getName().equals(name))
                    .findFirst();
    }

    public void deleteTraining(int id){
        /*if(!trainings.removeIf(t -> t.getId() == id)){
            throw new TrainingNichtGefundenException(id);
        }*/
        if(!trainingRepository.existsById(id)){
            throw new TrainingNichtGefundenException(id);
        }
        trainingRepository.deleteById(id);
    }

    public void deleteAllTrainings(){
        trainingRepository.deleteAll();
    }

    public TrainingModel update(int id, TrainingModel tm){
        /*TrainingModel vorhanden = trainings.stream()
                                        .filter(t -> t.getId() == id)
                                        .findFirst()
                                        .orElseThrow(() -> new TrainingNichtGefundenException(id));

        int index = trainings.indexOf(vorhanden);
        tm.setId(id);
        trainings.set(index, tm);
        return tm;*/
        trainingRepository.findById(id).orElseThrow(() -> new TrainingNichtGefundenException(id));
        tm.setId(id);
        return trainingRepository.save(tm);
    }

    public List<TrainingModel> alle(){
        return trainingRepository.findAll();
    }
}    