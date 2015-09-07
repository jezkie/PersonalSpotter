package com.jescy.spotter.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class GenericDaoImpl<T, ID extends Serializable> implements GenericDao<T, ID> {

	private Class<T> persistentClass;

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	@Override
	public Serializable save(final T object) {
		return sessionFactory.getCurrentSession().save(object);
	}

	@Override
	public void saveOrUpdate(final T object) {
		sessionFactory.getCurrentSession().saveOrUpdate(object);
	}

	@Override
	public void delete(final T object) {
		sessionFactory.getCurrentSession().delete(object);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getById(final Integer id) {
		return (T) sessionFactory.getCurrentSession().get(getPersistentClass(), id);
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

}
