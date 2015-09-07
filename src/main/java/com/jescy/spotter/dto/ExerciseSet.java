package com.jescy.spotter.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "exercise_set")
public class ExerciseSet {
	private Integer id;
	private Integer exerciseSet;
	private Integer reps;
	private Integer weight;
	private Date date;
	private String remarks;

	private Exercise exercise;

	/**
	 * @return the id
	 */
	@Id
	@GenericGenerator(name = "incr", strategy = "increment")
	@GeneratedValue(generator = "incr")
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the exerciseSet
	 */
	@Column(name = "exercise_set")
	public Integer getExerciseSet() {
		return exerciseSet;
	}

	/**
	 * @param exerciseSet
	 *            the exerciseSet to set
	 */
	public void setExerciseSet(Integer exerciseSet) {
		this.exerciseSet = exerciseSet;
	}

	/**
	 * @return the reps
	 */
	@Column(name = "reps")
	public Integer getReps() {
		return reps;
	}

	/**
	 * @param reps
	 *            the reps to set
	 */
	public void setReps(Integer reps) {
		this.reps = reps;
	}

	/**
	 * @return the weight
	 */
	@Column(name = "weight")
	public Integer getWeight() {
		return weight;
	}

	/**
	 * @param weight
	 *            the weight to set
	 */
	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	/**
	 * @return the date
	 */
	@Column(name = "date")
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the remarks
	 */
	@Column(name = "remarks")
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks
	 *            the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * @return the exercise
	 */
	@ManyToOne
	@JoinColumn(name = "exercise_id", insertable = false, updatable = false, nullable = false)
	public Exercise getExercise() {
		return exercise;
	}

	/**
	 * @param exercise
	 *            the exercise to set
	 */
	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}

}
