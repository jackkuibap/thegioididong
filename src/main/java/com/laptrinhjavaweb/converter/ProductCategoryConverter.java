package com.laptrinhjavaweb.converter;

import org.modelmapper.ModelMapper;

import com.laptrinhjavaweb.api.output.ProductCategoryOutput;
import com.laptrinhjavaweb.dto.ProductCategoryDTO;
import com.laptrinhjavaweb.entity.ProductCategoryEntity;

public class ProductCategoryConverter extends AbstractConverter<ProductCategoryDTO, ProductCategoryEntity>{
	private ModelMapper modelMapper = new ModelMapper(); 
	
	public ProductCategoryDTO convertEntityToDto(ProductCategoryEntity entity) {
		ProductCategoryDTO productCategoryDTO = modelMapper.map(entity, ProductCategoryDTO.class);
		return productCategoryDTO;
	}
	
	public ProductCategoryEntity convertDtoToEntity(ProductCategoryDTO dto) {
		ProductCategoryEntity productCategoryEntity = modelMapper.map(dto, ProductCategoryEntity.class);
		return productCategoryEntity;
	}
	
	public ProductCategoryOutput converEntityToOutput(ProductCategoryEntity entity) {
		ProductCategoryOutput productCategoryOutput = modelMapper.map(entity, ProductCategoryOutput.class);
		return productCategoryOutput;
	}
}
