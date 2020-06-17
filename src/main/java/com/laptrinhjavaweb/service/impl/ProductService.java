package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.converter.ProductConverter;
import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.entity.ProductEntity;
import com.laptrinhjavaweb.repository.impl.ProductRepository;
import com.laptrinhjavaweb.service.IProductService;

public class ProductService implements IProductService {
	
	private ProductRepository productRepository = new ProductRepository();
	private ProductConverter productConverter = new ProductConverter();
	
	public List<ProductDTO> findAll(){
		//java 7
		List<ProductDTO> results = new ArrayList<>();
		List<ProductEntity> productEntities = productRepository.findAll();
		for (ProductEntity entity: productEntities) {
			ProductDTO productDTO = productConverter.convertEntityToDto(entity);
			results.add(productDTO);
		}
		return results;
	}
	
	public List<ProductDTO> findAll(String name, String address){
		return null;
	}

	@Override
	public void insert(ProductDTO dto) {
		productRepository.insert(productConverter.convertDtoToEntity(dto));
	}
}
