package com.laptrinhjavaweb.mapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.laptrinhjavaweb.annotation.Column;
import com.laptrinhjavaweb.annotation.Entity;

public class ResultSetMapper<T> {
	
	@SuppressWarnings("unchecked")
	public List<T> mapRow(ResultSet rs, Class<T> zClass) {
		List<T> results = new ArrayList<>();
		try {
			if (zClass.isAnnotationPresent(Entity.class)) {
				ResultSetMetaData resultSetMetaData = rs.getMetaData();
			//	Field[] fields = zClass.getDeclaredFields();
			//	Field[] fields = zClass.getSuperclass().getDeclaredFields();
				List<Field> fields = new ArrayList<Field>();
		        for (Class<T> c = zClass; c != null; c = (Class<T>) c.getSuperclass()) {
		            fields.addAll(Arrays.asList(c.getDeclaredFields()));
		        }

				while (rs.next()) {
					T object = zClass.newInstance();  // dinh nghia lai  
					for (int i = 0; i< resultSetMetaData.getColumnCount(); i++) {
						String columnName = resultSetMetaData.getColumnName(i + 1);
						Object columnValue = rs.getObject(i + 1);
						for (Field field : fields) {
							if (field.isAnnotationPresent(Column.class)) {
								Column column = field.getAnnotation(Column.class);
								if (column.name().equals(columnName)) {
									if (columnValue != null)
									 BeanUtils.setProperty(object, field.getName(), columnValue);
									 break;
								}
							}
						}
					}	
					results.add(object);
				}
			}
		} catch (SQLException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
			System.out.println(e.getMessage());
		}
		return results;
	}
}
