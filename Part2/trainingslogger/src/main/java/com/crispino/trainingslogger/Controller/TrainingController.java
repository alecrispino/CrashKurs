package com.crispino.trainingslogger.controller;

import com.crispino.trainingslogger.model.TrainingModel;
import com.crispino.trainingslogger.service.TrainingService;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class TrainingController{

    private final TrainingService trainingService;

    public TrainingController(TrainingService trainingService){
        this.trainingService = trainingService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/trainings")
    public List<TrainingModel> alleTrainings() {
        return trainingService.alle();
    }

    @GetMapping("/trainings/sparring")
    public List<TrainingModel> getMethodName() {
        return trainingService.nurSparring();
    }

    @PostMapping("/trainings")
    public TrainingModel addTraining(@RequestBody TrainingModel training) {
        trainingService.hinzufuegen(training);
        return training;
    }
    
    
    
    
}
