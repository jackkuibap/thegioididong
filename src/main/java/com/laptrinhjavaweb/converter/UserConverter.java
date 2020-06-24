package com.laptrinhjavaweb.converter;

import org.modelmapper.ModelMapper;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.UserEntity;

public class UserConverter extends AbstractConverter<UserDTO, UserEntity>{
	private ModelMapper modelMapper = new ModelMapper(); 
	
	public UserDTO convertEntityToDto(UserEntity entity) {
		UserDTO userDTO = modelMapper.map(entity, UserDTO.class);
		return userDTO;
	}
	
	public UserEntity convertDtoToEntity(UserDTO dto) {
		UserEntity userEntity = modelMapper.map(dto, UserEntity.class);
		return userEntity;
	}
}
