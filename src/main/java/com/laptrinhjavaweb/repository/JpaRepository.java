package com.laptrinhjavaweb.repository;

import java.util.List;

public interface JpaRepository<T> {
	List<T> findAll();
	List<T> findAll(Object ...where);
	List<T> findAll(String sql, Object ...where);
	void insert(String sql, Object ...objects);
	void insert(Object object);
	void update(Object object);
}
