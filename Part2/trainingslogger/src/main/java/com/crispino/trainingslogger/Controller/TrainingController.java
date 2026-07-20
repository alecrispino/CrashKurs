package com.crispino.trainingslogger.controller;

import com.crispino.trainingslogger.exception.TrainingNichtGefundenException;
import com.crispino.trainingslogger.model.TrainingModel;
import com.crispino.trainingslogger.service.TrainingService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



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
    public ResponseEntity<TrainingModel> addTraining(@RequestBody TrainingModel training) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(trainingService.hinzufuegen(training));
    }

   @PutMapping("trainings/{id}")
   public ResponseEntity<TrainingModel> putMethodName(@PathVariable int id, @RequestBody TrainingModel training) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(trainingService.update(id, training));
   }

    @DeleteMapping("trainings/{id}")
    public ResponseEntity<Void> deleteTraining(@PathVariable int id){
        trainingService.deleteTraining(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("trainings")
    public ResponseEntity<Void> deleteAllTrainings(){
        trainingService.deleteAllTrainings();
        return ResponseEntity.noContent().build();
    }
}
