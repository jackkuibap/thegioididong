package com.laptrinhjavaweb.repository;

import java.util.List;

import com.laptrinhjavaweb.entity.ProductCategoryEntity;

public interface IProductCategoryRepository extends JpaRepository<ProductCategoryEntity>{
	List<ProductCategoryEntity> findAll();
}
