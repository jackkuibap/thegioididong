package com.laptrinhjavaweb.repository.impl;

import java.util.List;

import com.laptrinhjavaweb.entity.ProductCategoryEntity;
import com.laptrinhjavaweb.repository.IProductCategoryRepository;

public class ProductCategoryRepository extends SimpleJpaRepository<ProductCategoryEntity> implements IProductCategoryRepository {

	@Override
	public List<ProductCategoryEntity> findAll() {
		String sql = "select * from productcategory";
		return this.findAll(sql);
	}

}
