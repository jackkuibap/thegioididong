package com.laptrinhjavaweb.repository.impl;

import java.util.List;

import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.IUserRepository;

public class UserRepository extends SimpleJpaRepository<UserEntity> implements IUserRepository {

	@Override
	public List<UserEntity> findByRole(String roleCode) {
		StringBuilder sql = new StringBuilder("select * from user u");
		sql.append(" inner join userrole ur on u.id = ur.userid");
		sql.append(" inner join role r on r.id = ur.roleid");
		sql.append(" where r.code = '"+roleCode+"'");
		return this.findAll(sql.toString());
	}
	
}
