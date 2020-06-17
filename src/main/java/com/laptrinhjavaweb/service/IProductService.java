package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.builder.ProductSearchBuilder;
import com.laptrinhjavaweb.dto.ProductDTO;

public interface IProductService {
	List<ProductDTO> findAll();
	List<ProductDTO> findAll(ProductSearchBuilder builder);
	void insert(ProductDTO dto);
}
