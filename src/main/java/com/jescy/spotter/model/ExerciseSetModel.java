package com.jescy.spotter.model;

import java.util.Date;

public class ExerciseSetModel {
	
	private Integer set;
	
	private Integer reps;
	
	private Date date;
	
	private String remarks;

	/**
	 * @return the set
	 */
	public Integer getSet() {
		return set;
	}

	/**
	 * @param set the set to set
	 */
	public void setSet(Integer set) {
		this.set = set;
	}

	/**
	 * @return the reps
	 */
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
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
	
	
}
