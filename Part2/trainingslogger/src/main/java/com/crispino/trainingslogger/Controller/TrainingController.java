package com.crispino.trainingslogger.Controller;

import com.crispino.trainingslogger.Model.TrainingModel;
import com.crispino.trainingslogger.Service.TrainingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;


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
    
    
    
}
