package com.laptrinhjavaweb.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.laptrinhjavaweb.api.output.ProductCategoryOutput;
import com.laptrinhjavaweb.converter.ProductCategoryConverter;
import com.laptrinhjavaweb.entity.ProductCategoryEntity;
import com.laptrinhjavaweb.repository.IProductCategoryRepository;
import com.laptrinhjavaweb.repository.impl.ProductCategoryRepository;
import com.laptrinhjavaweb.service.IProductCategoryService;

public class ProductCategoryService implements IProductCategoryService{
	
	private IProductCategoryRepository productCategoryRepository = new ProductCategoryRepository();
	private ProductCategoryConverter productCategoryConverter = new ProductCategoryConverter();
	@Override
	public List<ProductCategoryOutput> findAll() {
		List<ProductCategoryEntity> entities = productCategoryRepository.findAll();
		List<ProductCategoryOutput> results = entities.stream()
				.map(item -> productCategoryConverter.converEntityToOutput(item))
				.collect(Collectors.toList());
		for (ProductCategoryOutput item:results) {
			item.setChecked("");
		}
		return results;
	}

}
