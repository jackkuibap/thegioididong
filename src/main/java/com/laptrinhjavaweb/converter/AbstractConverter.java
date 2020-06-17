package com.laptrinhjavaweb.converter;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.modelmapper.ModelMapper;

public class AbstractConverter<D,E> {
	
	private ModelMapper modelMapper = new ModelMapper();

	@SuppressWarnings("unchecked")
	public D convertEntityToDto(E entity) {
		Class<D> dto;
		Type type = getClass().getGenericSuperclass();
		ParameterizedType parameterizedType = (ParameterizedType) type;
		dto = (Class<D>) parameterizedType.getActualTypeArguments()[0];
		return modelMapper.map(entity, dto);
	}
	
	@SuppressWarnings("unchecked")
	public E convertDtoToEntity(D dto) {
		Class<E> entity;
		Type type = getClass().getGenericSuperclass();
		ParameterizedType parameterizedType = (ParameterizedType) type;
		entity = (Class<E>) parameterizedType.getActualTypeArguments()[0];
		return modelMapper.map(dto, entity);
	}
}
