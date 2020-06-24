package com.laptrinhjavaweb.repository;

import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.builder.ProductSearchBuilder;
import com.laptrinhjavaweb.entity.ProductEntity;

public interface IProductRepository extends JpaRepository<ProductEntity> {
	List<ProductEntity> findAll(Map<String, Object> params, ProductSearchBuilder builder);
	ProductEntity findByID(Long id);
}
