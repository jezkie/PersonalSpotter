package com.jescy.spotter.model;

import java.util.ArrayList;
import java.util.List;

public class ExerciseDataGridModel {
	
	private List<ExerciseDecorator> exercises;

	public void addExercise(ExerciseDecorator exerciseDecorator){
		if (exercises == null) {
			exercises = new ArrayList<ExerciseDecorator>();
		}
		
		exercises.add(exerciseDecorator);
	}
	
	
	/**
	 * @return the exercises
	 */
	public List<ExerciseDecorator> getExercises() {
		return exercises;
	}

	/**
	 * @param exercises the exercises to set
	 */
	public void setExercises(List<ExerciseDecorator> exercises) {
		this.exercises = exercises;
	}
	
}
