package com.jescy.spotter.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jescy.spotter.dto.Exercise;

public class ExerciseDecorator {
	
	public ExerciseDecorator(){}
	
	public List<ExerciseSetModel> getExerciseSet(){
		List<ExerciseSetModel> exerciseSetModels = new ArrayList<ExerciseSetModel>();
		
		for (int i = 0; i < this.getSets(); i++) {
			ExerciseSetModel exerciseSetModel = new ExerciseSetModel();
			exerciseSetModel.setSet(i+1);
			exerciseSetModel.setReps(this.getReps());
			exerciseSetModel.setDate(new Date());
			exerciseSetModels.add(exerciseSetModel);
		}
		
		return exerciseSetModels;
	}
	
	public ExerciseDecorator(Exercise e){
		this.exercise = e;
	}
	
	private Exercise exercise = new Exercise();
	
	/**
	 * @return the exercise
	 */
	public Exercise getExercise() {
		return exercise;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return exercise.getId();
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.exercise.setId(id);
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return exercise.getName();
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.exercise.setName(name);
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return exercise.getDescription();
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.exercise.setDescription(description);
	}
	/**
	 * @return the autoAdd
	 */
	public Integer getAutoAdd() {
		return exercise.getAutoAdd();
	}
	/**
	 * @param autoAdd the autoAdd to set
	 */
	public void setAutoAdd(Integer autoAdd) {
		this.exercise.setAutoAdd(autoAdd);
	}
	/**
	 * @return the rest
	 */
	public Integer getRest() {
		return exercise.getRest();
	}
	/**
	 * @param rest the rest to set
	 */
	public void setRest(Integer rest) {
		this.exercise.setRest(rest);
	}
	/**
	 * @return the autoFlag
	 */
	public boolean isAutoFlag() {
		return exercise.isAutoFlag();
	}
	/**
	 * @param autoFlag the autoFlag to set
	 */
	public void setAutoFlag(boolean autoFlag) {
		this.exercise.setAutoFlag(autoFlag);
	}
	/**
	 * @param exercise the exercise to set
	 */
	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}
	
	/**
	 * @return the reps
	 */
	public Integer getReps() {
		return exercise.getReps();
	}

	/**
	 * @param reps the reps to set
	 */
	public void setReps(Integer reps) {
		this.exercise.setReps(reps);
	}

	/**
	 * @return the sets
	 */
	public Integer getSets() {
		return exercise.getSets();
	}

	/**
	 * @param sets the sets to set
	 */
	public void setSets(Integer sets) {
		this.exercise.setSets(sets);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((exercise == null) ? 0 : exercise.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExerciseDecorator other = (ExerciseDecorator) obj;
		if (exercise == null) {
			if (other.exercise != null)
				return false;
		} else if (!exercise.equals(other.exercise))
			return false;
		return true;
	}
	
	
}

