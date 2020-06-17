package com.laptrinhjavaweb.repository.impl;

import com.laptrinhjavaweb.entity.ProductEntity;
import com.laptrinhjavaweb.repository.IProductRepository;

public class ProductRepository extends SimpleJpaRepository<ProductEntity> implements IProductRepository {

	/*@Override
	public void insert(ProductEntity entity) {
		String sql = "insert into Product(Name,Code,Cost) values(?,?,?)";
		this.insert(sql, entity.getName(), entity.getCode(), entity.getCost());
	}
	*/

}
