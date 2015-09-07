package com.jescy.spotter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jescy.spotter.dao.ExerciseDao;
import com.jescy.spotter.dto.Exercise;
import com.jescy.spotter.model.ExerciseDecorator;

@Service(value = "exerciseService")
public class ExerciseServiceImpl implements ExerciseService {

	@Autowired
	private ExerciseDao exerciseDao;

	@Transactional
	@Override
	public void saveOrUpdate(ExerciseDecorator e) {
		exerciseDao.saveOrUpdate(e.getExercise());
	}

	@Transactional(readOnly=true)
	@Override
	public ExerciseDecorator getExerciseById(Integer id) {
		Exercise e = exerciseDao.getById(id);
		return new ExerciseDecorator(e);
	}

	@Transactional(readOnly = true)
	@Override
	public List<ExerciseDecorator> getExercises() {
		List<Exercise> exercises = exerciseDao.getExerciseList();
		List<ExerciseDecorator> exerciseWrappers = new ArrayList<ExerciseDecorator>();
		for (Exercise exercise : exercises) {
			exerciseWrappers.add(new ExerciseDecorator(exercise));
		}

		return exerciseWrappers;
	}

}
