package com.laptrinhjavaweb.repository.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;

import com.laptrinhjavaweb.builder.ProductSearchBuilder;
import com.laptrinhjavaweb.entity.ProductEntity;
import com.laptrinhjavaweb.repository.IProductRepository;

public class ProductRepository extends SimpleJpaRepository<ProductEntity> implements IProductRepository {

	@Override
	public List<ProductEntity> findAll(Map<String, Object> params, ProductSearchBuilder builder) {
		StringBuilder sql = new StringBuilder("select * from product t");
		if (builder.getStoreID()!= null && builder.getStoreID() > 0L) {
			sql.append(" inner join storeproduct sp on t.id = sp.productid");
		}
		sql.append(" where 1=1");
		sql = this.createSQLfindAllCommon(sql, params);
		sql = createSQLspecial(sql, builder);
		return this.findAll(sql.toString());
	}

	private StringBuilder createSQLspecial(StringBuilder sql, ProductSearchBuilder builder) {
		if (StringUtils.isNotBlank(builder.getCostFrom())|| StringUtils.isNotBlank(builder.getCostTo())){
			if (StringUtils.isNotBlank(builder.getCostFrom())) {
				sql.append(" AND t.cost >= "+builder.getCostFrom()+"");
			}
			if (StringUtils.isNotBlank(builder.getCostTo())) {
				sql.append(" AND t.cost <= "+builder.getCostTo()+"");
			}
			
		}
		
		if (builder.getBrand() != null) {		
			sql.append(" and exists (select * from ProductCategory pc where t.productcategoryid = pc.id");
			sql.append(" AND pc.name like '%"+builder.getBrand()+"%'");
			sql.append(")");
		}
		
			
			
			
		//java 7
		/*if(builder.getFeatures().length > 0) {
			sql.append(" and (");
			for (String feature: builder.getFeatures()) {
				if (feature.equals(builder.getFeatures()[0])) {
					sql.append("t.feature like '%"+feature+"%'");
				} else {
					sql.append(" or t.feature like '%"+feature+"%'");
				}
			}
			sql.append(")");
		}*/
		
		//java8
		if (builder.getFeatures().length > 0) {
			sql.append(" and (");
			String sqlFeature = Arrays.stream(builder.getFeatures())
					.map(item -> "(t.feature like '%"+item+"%')")
					.collect(Collectors.joining(" or "));
			sql.append(sqlFeature);
			sql.append(")");
		}
			
		if (builder.getStoreID()!= null && builder.getStoreID() > 0L) {
			sql.append(" and sp.storeid = "+builder.getStoreID()+"");
		}
		return sql;
	}

	@Override
	public ProductEntity findByID(Long id) {
		String sql = "SELECT * FROM product WHERE id = "+id.toString();
		List<ProductEntity> productEntities = findAll(sql);
		return productEntities.isEmpty() ? null : productEntities.get(0);
	}

	
	/*
	 * @Override public void insert(ProductEntity entity) { String sql =
	 * "insert into Product(Name,Code,Cost) values(?,?,?)"; this.insert(sql,
	 * entity.getName(), entity.getCode(), entity.getCost()); }
	 */

}
