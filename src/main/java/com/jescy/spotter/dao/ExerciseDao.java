/**
 * 
 */
package com.jescy.spotter.dao;

import java.util.List;

import com.jescy.spotter.dto.Exercise;

/**
 * @author JEZKIE
 * @param <T>
 *
 */
public interface ExerciseDao extends GenericDao<Exercise, Integer> {
	List<Exercise> getExerciseList();
}
