package com.laptrinhjavaweb.repository;

import java.util.List;
import java.util.Map;

public interface JpaRepository<T> {
//	List<T> findAll();
	List<T> findAll(Map<String, Object> params, Object ...where);
	List<T> findAll(String sql, Object ...where);
	void insert(String sql, Object ...objects);
	Long insert(Object object);
	void update(Object object);
}
