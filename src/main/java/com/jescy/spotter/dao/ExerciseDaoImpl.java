package com.jescy.spotter.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jescy.spotter.dto.Exercise;

@Repository
public class ExerciseDaoImpl extends GenericDaoImpl<Exercise, Integer>implements ExerciseDao {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Exercise> getExerciseList() {
		return sessionFactory.getCurrentSession().createQuery("from Exercise").list();
	}
}
