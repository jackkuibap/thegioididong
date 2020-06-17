package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.converter.AbstractConverter;
import com.laptrinhjavaweb.repository.impl.SimpleJpaRepository;
import com.laptrinhjavaweb.service.GenericService;

public class AbstractService <D,E> implements GenericService<D, E> {
/*	@SuppressWarnings("unchecked")
	public <T> Class<T> getGenericClass() {
		Class<T> zClass;
		Type type = getClass().getGenericSuperclass();
		ParameterizedType parameterizedType = (ParameterizedType) type;
		zClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
		return zClass;
	}*/
	private SimpleJpaRepository<E> repository = new SimpleJpaRepository<>();
	private AbstractConverter<D, E> converter = new AbstractConverter<>();
	
	public List<D> findAll(){
		//java 7
		List<D> dtos = new ArrayList<>();
		List<E> entities = repository.findAll();
		for (E entity: entities) {
			D dto = converter.convertEntityToDto(entity);
			dtos.add(dto);
		}
		return dtos;
	}
	
}
