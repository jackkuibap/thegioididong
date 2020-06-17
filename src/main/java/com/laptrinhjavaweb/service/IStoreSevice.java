package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.dto.StoreDTO;

public interface IStoreSevice {
	List<StoreDTO> findAll();
	void insert(StoreDTO dto);
}
