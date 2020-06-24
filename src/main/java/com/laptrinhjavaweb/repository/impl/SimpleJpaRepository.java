package com.laptrinhjavaweb.repository.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.laptrinhjavaweb.annotation.Column;
import com.laptrinhjavaweb.annotation.Table;
import com.laptrinhjavaweb.mapper.ResultSetMapper;
import com.laptrinhjavaweb.repository.EntityManagerFactory;
import com.laptrinhjavaweb.repository.JpaRepository;
import com.mysql.cj.protocol.Resultset;

public class SimpleJpaRepository<T> implements JpaRepository<T> {
	
	private Class<T> zClass;

	@SuppressWarnings("unchecked")
	public SimpleJpaRepository() {
		Type type = getClass().getGenericSuperclass();
		ParameterizedType parameterizedType = (ParameterizedType) type;
		zClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
	}
	
	
/*	public List<T> findAll(){
		ResultSetMapper<T> resultSetMapper = new ResultSetMapper<>();
		
		Connection conn = EntityManagerFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String tableName = "";
		if (conn != null) {
			try {
				if (zClass.isAnnotationPresent(Table.class)) {
					Table table = zClass.getAnnotation(Table.class);
					tableName = table.name();
				}
				
				String sql = "select * from " + tableName + "";
				stmt = conn.prepareStatement(sql);
				rs = stmt.executeQuery();
				
				
				
				return resultSetMapper.mapRow(rs, this.zClass);
				
			} catch (SQLException se) {
				// Handle errors for JDBC
				se.printStackTrace();
				return new ArrayList<>();
			} finally {
				// finally block used to close resources
				try {
					if (stmt != null)
						conn.close();
					if (stmt != null)
						stmt.close();
					if (rs != null)
						rs.close();
				} catch (SQLException se) {
					System.out.println(se.getMessage());
				} 
			} 
		}
		return new ArrayList<>();

	}
*/
	@Override
	public void insert(String sql, Object... objects) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = EntityManagerFactory.getConnection();
			connection.setAutoCommit(false); //tu dong commit du bi fail di nua -> khong cho phep
			statement = connection.prepareStatement(sql);
			int index = 1;
			for (Object object: objects) {
				statement.setObject(index, object); //cach moi doi voi kieu string thi set kieu du lieu string
				index ++;
				/*
				if (object instanceof String) {
					statement.setString(index, (String) object);
				} else if (object instanceof Long) {
					statement.setLong(index, (Long) object);
				}
				*/
			}
			statement.executeUpdate();
			//statement = connection.createStatement();
			//statement.executeUpdate(sql);
			connection.commit();

		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					//e1.printStackTrace();
					System.out.println(e1.getMessage());
				}
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}

			} catch (SQLException e2) {
				//e2.printStackTrace();
				System.out.println(e2.getMessage());
			}
		}
		
	}

	@Override
	public Long insert(Object object) {
		String sql = createSQLInsert();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = EntityManagerFactory.getConnection();
			connection.setAutoCommit(false); //tu dong commit du bi fail di nua -> khong cho phep
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			//convert object -> object class
			Class<?> aClass = object.getClass(); // dau ? co nghia la khong biet object class la gi ca, ban than object cung ko biet la gi
			int index = 1;
			for (Field aField: aClass.getDeclaredFields()) {
				aField.setAccessible(true);// muon truy cap aField phai bat co cho phep
				statement.setObject(index, aField.get(object)); //cach moi doi voi kieu string thi set kieu du lieu string
				index ++;
				
				/*if (object instanceof String) {
					statement.setString(index, (String) object);
				} else if (object instanceof Long) {
					statement.setLong(index, (Long) object);
				}*/
				
			}
			
			Class<?> parentClass = aClass.getSuperclass();
			int indexParent = aClass.getDeclaredFields().length + 1;
			while (parentClass != null) {
				for (Field aField: parentClass.getDeclaredFields()) {
					aField.setAccessible(true);// muon truy cap aField phai bat co cho phep
					statement.setObject(indexParent, aField.get(object)); //cach moi doi voi kieu string thi set kieu du lieu string
					indexParent++;		
				}
				parentClass = parentClass.getSuperclass();
			}
			
			int result = statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			//statement = connection.createStatement();
			//statement.executeUpdate(sql);
			connection.commit();
			if (result > 0) {
				while (resultSet.next()) {
					Long id = resultSet.getLong(1);
					return id;
				}
			}

		} catch (SQLException | IllegalAccessException e) {
			if (connection != null) {
				try {
					connection.rollback();
					System.out.println("e.getMessage()"+e.getMessage());
				} catch (SQLException e1) {
					//e1.printStackTrace();
					System.out.println("e1.getMessage()"+e1.getMessage());
				}
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}

			} catch (SQLException e2) {
				//e2.printStackTrace();
				System.out.println("e2.getMessage()"+e2.getMessage());
			}
		}
		return -1L;
	}

	public void update(Object object) {
		String sql = createSQLUpdate();
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = EntityManagerFactory.getConnection();
			connection.setAutoCommit(false); //tu dong commit du bi fail di nua -> khong cho phep
			statement = connection.prepareStatement(sql);
			//convert object -> object class
			Class<?> aClass = object.getClass(); // dau ? co nghia la khong biet object class la gi ca, ban than object cung ko biet la gi
			int index = 1;
			for (Field aField: aClass.getDeclaredFields()) {
				aField.setAccessible(true);// muon truy cap aField phai bat co cho phep
				statement.setObject(index, aField.get(object)); //cach moi doi voi kieu string thi set kieu du lieu string
				index ++;
				
				/*if (object instanceof String) {
					statement.setString(index, (String) object);
				} else if (object instanceof Long) {
					statement.setLong(index, (Long) object);
				}*/
				
			}
			
			statement.executeUpdate();
			//statement = connection.createStatement();
			//statement.executeUpdate(sql);
			connection.commit();

		} catch (SQLException | IllegalAccessException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					//e1.printStackTrace();
					System.out.println(e1.getMessage());
				}
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}

			} catch (SQLException e2) {
				//e2.printStackTrace();
				System.out.println(e2.getMessage());
			}
		}
		
	}
	private String createSQLInsert() {
		String tableName = "";
		if (zClass.isAnnotationPresent(Table.class)) {
			Table table = zClass.getAnnotation(Table.class);
			tableName = table.name();
		}
		
		StringBuilder fields = new StringBuilder("");
		StringBuilder params = new StringBuilder("");
		for (Field field: zClass.getDeclaredFields()) {
			if (fields.length() > 1) {
				fields.append(",");
				params.append(",");
			}
			if (field.isAnnotationPresent(Column.class)) {
				Column column = field.getAnnotation(Column.class);
				fields.append(column.name());
				params.append("?");							
			}
		}
		Class<?> parentClass = zClass.getSuperclass();
		while (parentClass != null) {
			for (Field field: parentClass.getDeclaredFields()) {
				if (fields.length() > 1) {
					fields.append(",");
					params.append(",");
				}
				if (field.isAnnotationPresent(Column.class)) {
					Column column = field.getAnnotation(Column.class);
					fields.append(column.name());
					params.append("?");							
				}
			}
			parentClass = parentClass.getSuperclass();
		}
		String sql = "INSERT INTO "+tableName+"("+fields.toString()+") VALUES ("+params.toString()+")";
		return sql;
	}

	private String createSQLUpdate() {
		String tableName = "";
		if (zClass.isAnnotationPresent(Table.class)) {
			Table table = zClass.getAnnotation(Table.class);
			tableName = table.name();
		}
		
		StringBuilder updates = new StringBuilder("");
		for (Field field: zClass.getDeclaredFields()) {
			if (field.isAnnotationPresent(Column.class)) {
				Column column = field.getAnnotation(Column.class);
				if (column.name()!= "ID") {
					updates.append(", ");
					updates.append(column.name());
					updates.append(" = ?");	
				}
			}
		}
		String sql = "UPDATE "+tableName+" SET "+updates.toString()+" WHERE ID = ?";
		return sql;
	}

	@Override
	public List<T> findAll(String sql, Object ...where) {
		ResultSetMapper<T> resultSetMapper = new ResultSetMapper<>();
		
		Connection conn = EntityManagerFactory.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
//		String tableName = "";
		if (conn != null) {
			try {
//				if (zClass.isAnnotationPresent(Table.class)) {
//					Table table = zClass.getAnnotation(Table.class);
//					tableName = table.name();
//				}
				
	//			StringBuilder sql = new StringBuilder("select * from " + tableName + "");
				StringBuilder builder = new StringBuilder(sql);
				if (where != null && where.length == 1) {
					builder.append(where[0]);
				}
				
				//stmt = conn.prepareStatement(builder.toString());
				stmt = conn.createStatement();
				rs = stmt.executeQuery(builder.toString());
				
				return resultSetMapper.mapRow(rs, this.zClass);
				
			} catch (SQLException se) {
				// Handle errors for JDBC
				se.printStackTrace();
				return new ArrayList<>();
			} finally {
				// finally block used to close resources
				try {
					if (stmt != null)
						conn.close();
					if (stmt != null)
						stmt.close();
					if (rs != null)
						rs.close();
				} catch (SQLException se) {
					System.out.println(se.getMessage());
				} 
			} 
		}
		return new ArrayList<>();
	}

	@Override
	public List<T> findAll(Map<String, Object> params, Object... where) {
		ResultSetMapper<T> resultSetMapper = new ResultSetMapper<>();
		
		Connection conn = EntityManagerFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String tableName = "";
		if (conn != null) {
			try {
				if (zClass.isAnnotationPresent(Table.class)) {
					Table table = zClass.getAnnotation(Table.class);
					tableName = table.name();
				}
				
				StringBuilder sql = new StringBuilder("select * from "+tableName+" t where 1=1");
				sql = createSQLfindAllCommon(sql, params);
				if (where != null && where.length == 1) {
					sql.append(where[0]);
				}
				
				stmt = conn.prepareStatement(sql.toString());
				rs = stmt.executeQuery();
				
				return resultSetMapper.mapRow(rs, this.zClass);
				
			} catch (SQLException se) {
				// Handle errors for JDBC
				se.printStackTrace();
				return new ArrayList<>();
			} finally {
				// finally block used to close resources
				try {
					if (stmt != null)
						conn.close();
					if (stmt != null)
						stmt.close();
					if (rs != null)
						rs.close();
				} catch (SQLException se) {
					System.out.println(se.getMessage());
				} 
			} 
		}
		return new ArrayList<>();
	}

	protected StringBuilder createSQLfindAllCommon(StringBuilder sql, Map<String, Object> params) {

		if (params != null && params.size() > 0) {
			String[] keys = new String[params.size()];
			Object[] values = new Object[params.size()];
			int i = 0;
			for (Map.Entry<String, Object> item: params.entrySet()) {
				keys[i] = item.getKey();
				values[i] = item.getValue();
				i++;
			}
			
			for (int j = 0; j < keys.length; j++) {
				if (values[j] instanceof String) {
					if (StringUtils.isNotBlank(values[j].toString())) {
						sql.append(" AND t."+keys[j]+" like '%"+values[j]+"%'");
					}
				} else {
					if (values[j] != null) {
						sql.append(" AND t."+keys[j]+" = "+values[j]+"");
					}
				}
			}
		}
		return sql;
		
	}

}
