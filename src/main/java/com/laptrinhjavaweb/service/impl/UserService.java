package com.laptrinhjavaweb.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.laptrinhjavaweb.converter.UserConverter;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.IUserRepository;
import com.laptrinhjavaweb.repository.impl.UserRepository;
import com.laptrinhjavaweb.service.IUserService;

public class UserService implements IUserService{
	
	private IUserRepository userRepository = new UserRepository();
	private UserConverter userConverter = new UserConverter();
	
	@Override
	public List<UserDTO> findStaffs(String roleCode) {
		List<UserEntity> entities = userRepository.findByRole(roleCode);
		List<UserDTO> results = entities.stream()
								.map(item -> userConverter.convertEntityToDto(item))
								.collect(Collectors.toList());
		return results;
	}

}
