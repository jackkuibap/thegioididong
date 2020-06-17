package com.laptrinhjavaweb.service.impl;

import java.util.List;

import com.laptrinhjavaweb.converter.StoreConverter;
import com.laptrinhjavaweb.dto.StoreDTO;
import com.laptrinhjavaweb.repository.IStoreRepository;
import com.laptrinhjavaweb.repository.impl.StoreRepository;
import com.laptrinhjavaweb.service.IStoreSevice;

public class StoreService implements IStoreSevice{

	private IStoreRepository storeRepository = new StoreRepository();
	private StoreConverter storeConverter = new StoreConverter();
	
	@Override
	public List<StoreDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(StoreDTO dto) {
		storeRepository.insert(storeConverter.convertDtoToEntity(dto));
		
	}

}
