package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.api.output.ProductCategoryOutput;

public interface IProductCategoryService {
	List<ProductCategoryOutput> findAll();
}
