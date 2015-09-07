package com.jescy.spotter.dao;

import java.io.Serializable;

public interface GenericDao<T, ID extends Serializable> {
	Serializable save(T e);

	void saveOrUpdate(T e);

	void delete(T e);

	T getById(Integer id);
}
