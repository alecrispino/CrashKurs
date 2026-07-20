package com.crispino.trainingslogger.repository;

import com.crispino.trainingslogger.model.TrainingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;


public interface TrainingRepository extends JpaRepository<TrainingModel, Integer>{
    List<TrainingModel> findBySparringTrue();

    Optional<TrainingModel> findByName(String name);

    @Query("SELECT SUM(t.dauerInMinuten) FROM TrainingModel t")
    Integer summeDauer();

    List<TrainingModel> findByDauerInMinutenGreaterThan(int minuten);
}