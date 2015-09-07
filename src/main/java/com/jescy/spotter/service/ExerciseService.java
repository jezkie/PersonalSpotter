package com.jescy.spotter.service;

import java.util.List;

import com.jescy.spotter.model.ExerciseDecorator;

public interface ExerciseService {
	
	void saveOrUpdate(ExerciseDecorator e);
	
	ExerciseDecorator getExerciseById(Integer id);
	
	List<ExerciseDecorator> getExercises();
}
