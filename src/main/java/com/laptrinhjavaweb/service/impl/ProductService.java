package com.laptrinhjavaweb.service.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;

import com.laptrinhjavaweb.api.output.ProductColorOutput;
import com.laptrinhjavaweb.builder.ProductSearchBuilder;
import com.laptrinhjavaweb.converter.ProductConverter;
import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.entity.ProductEntity;
import com.laptrinhjavaweb.enums.ProductColorEnum;
import com.laptrinhjavaweb.repository.IProductRepository;
import com.laptrinhjavaweb.repository.impl.ProductRepository;
import com.laptrinhjavaweb.service.IProductService;

public class ProductService implements IProductService {
	
	private IProductRepository productRepository = new ProductRepository();
	private ProductConverter productConverter = new ProductConverter();
	
/*	public List<ProductDTO> findAll(){
		//java 7
		List<ProductDTO> results = new ArrayList<>();
		List<ProductEntity> productEntities = productRepository.findAll();
		for (ProductEntity entity: productEntities) {
			ProductDTO productDTO = productConverter.convertEntityToDto(entity);
			results.add(productDTO);
		}
		return results;
	}
*/	

	@Override
	public ProductDTO insert(ProductDTO dto) {
		//productRepository.insert(productConverter.convertDtoToEntity(dto));
		ProductEntity entity = productConverter.convertDtoToEntity(dto);
		Long productID = productRepository.insert(entity);
		return productConverter.convertEntityToDto(productRepository.findByID(productID));
	}

	@Override
	public List<ProductDTO> findAll(ProductSearchBuilder builder) {
//		List<ProductDTO> results = new ArrayList<>();
		/*Map<String, Object> params = new HashMap<>();
		params.put("Name", builder.getName());
		params.put("Color", builder.getColor());
		params.put("Code", builder.getCode());
		params.put("Cost", builder.getCost());
		params.put("Feature", builder.getFeature());
		*/
		//params.put("cost", StringUtils.isNotBlank(builder.getCost()) ? Integer.parseInt(builder.getCost()) : null);
		Map<String, Object> params = convertToMapProperties(builder);
		
		List<ProductEntity> entities = productRepository.findAll(params, builder);
		//code kieu java 7
		/*for (ProductEntity item: entities) {
			ProductDTO dto = productConverter.convertEntityToDto(item);
			results.add(dto);
		}*/  //code kieu java 7��
		//code kieu java 8 ��
		List<ProductDTO> results = entities.stream()
											.map(item -> productConverter.convertEntityToDto(item))
											.collect(Collectors.toList());
		return results;
	}

	private Map<String, Object> convertToMapProperties(ProductSearchBuilder builder) {
			Map<String, Object> properties = new HashMap<>();
			try {
				Field[] fields = ProductSearchBuilder.class.getDeclaredFields();
				for (Field field: fields) {
					if (!field.getName().startsWith("cost") && !field.getName().equals("features")
						&& !field.getName().equals("brand") && !field.getName().equals("storeID")){
						field.setAccessible(true);
						if (field.get(builder) instanceof String) {
							properties.put(field.getName().toLowerCase(), field.get(builder));
						} else {
							if (field.get(builder) != null && StringUtils.isNotEmpty((String)field.get(builder))) {
								properties.put(field.getName().toLowerCase(), Integer.parseInt((String)field.get(builder)));
						
							}
						}
					}
				}
			} catch (IllegalAccessException e) {
				System.out.println(e.getMessage());
			}

		return properties;
	}

	@Override
	public List<ProductColorOutput> getProductColor() {
		List<ProductColorOutput> results = new ArrayList<>();
		for (ProductColorEnum item: ProductColorEnum.values()) {
			ProductColorOutput productColorOutput = new ProductColorOutput();
			productColorOutput.setName(item.toString());
			productColorOutput.setCode(item.getValue());
			results.add(productColorOutput);
		}
		return results;
	}

	@Override
	public Map<String, String> getMapProductColor() {
		Map<String, String> results = new HashMap<>();
		for (ProductColorEnum item: ProductColorEnum.values()) {
			results.put(item.toString(), item.getValue());
		}
		return results;
	}
}
