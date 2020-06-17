package com.laptrinhjavaweb.repository.impl;

import com.laptrinhjavaweb.entity.StoreEntity;
import com.laptrinhjavaweb.repository.IStoreRepository;

public class StoreRepository extends SimpleJpaRepository<StoreEntity> implements IStoreRepository {

	/*@Override
	public void insert(StoreEntity entity) {
		String sql = "insert into Store(Name,Code) values(?,?)";
		this.insert(sql, entity.getName(), entity.getCode());
	}*/
	
}
