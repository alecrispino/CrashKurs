package com.crispino.trainingslogger.repository;

import com.crispino.trainingslogger.model.TrainingModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingRepository extends JpaRepository<TrainingModel, Integer>{}