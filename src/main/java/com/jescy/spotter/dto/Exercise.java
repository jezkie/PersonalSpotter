package com.jescy.spotter.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "exercises")
public class Exercise {

	private Integer id;
	private String name;
	private String description;
	private Integer autoAdd;
	private Integer rest;
	private Integer reps;
	private Integer sets;
	private boolean autoFlag;

	private List<ExerciseSet> exerciseSets;

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
	 * @return the name
	 */
	@Column(name = "name")
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the autoAdd
	 */
	@Column(name = "auto_add")
	public Integer getAutoAdd() {
		return autoAdd;
	}

	/**
	 * @param autoAdd
	 *            the autoAdd to set
	 */
	public void setAutoAdd(Integer autoAdd) {
		this.autoAdd = autoAdd;
	}

	/**
	 * @return the rest
	 */
	@Column(name = "rest")
	public Integer getRest() {
		return rest;
	}

	/**
	 * @param rest
	 *            the rest to set
	 */
	public void setRest(Integer rest) {
		this.rest = rest;
	}
	
	

	/**
	 * @return the reps
	 */
	@Column(name = "reps")
	public Integer getReps() {
		return reps;
	}

	/**
	 * @param reps the reps to set
	 */
	public void setReps(Integer reps) {
		this.reps = reps;
	}

	/**
	 * @return the sets
	 */
	@Column(name = "sets")
	public Integer getSets() {
		return sets;
	}

	/**
	 * @param sets the sets to set
	 */
	public void setSets(Integer sets) {
		this.sets = sets;
	}

	/**
	 * @return the autoFlag
	 */
	@Column(name = "auto_flag")
	public boolean isAutoFlag() {
		return autoFlag;
	}

	/**
	 * @param autoFlag
	 *            the autoFlag to set
	 */
	public void setAutoFlag(boolean autoFlag) {
		this.autoFlag = autoFlag;
	}

	/**
	 * @return the exerciseSets
	 */
	@OneToMany(mappedBy = "exercise")
	public List<ExerciseSet> getExerciseSets() {
		return exerciseSets;
	}

	/**
	 * @param exerciseSets
	 *            the exerciseSets to set
	 */
	public void setExerciseSets(List<ExerciseSet> exerciseSets) {
		this.exerciseSets = exerciseSets;
	}

}
