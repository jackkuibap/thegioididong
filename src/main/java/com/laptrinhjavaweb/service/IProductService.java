package com.laptrinhjavaweb.service;

import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.api.output.ProductColorOutput;
import com.laptrinhjavaweb.builder.ProductSearchBuilder;
import com.laptrinhjavaweb.dto.ProductDTO;

public interface IProductService {
//	List<ProductDTO> findAll();
	List<ProductDTO> findAll(ProductSearchBuilder builder);
	List<ProductColorOutput> getProductColor();
	ProductDTO insert(ProductDTO dto);
	Map<String, String> getMapProductColor();
}
