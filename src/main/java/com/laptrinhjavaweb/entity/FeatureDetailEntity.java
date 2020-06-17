package com.laptrinhjavaweb.entity;

import com.laptrinhjavaweb.annotation.Column;
import com.laptrinhjavaweb.annotation.Entity;
import com.laptrinhjavaweb.annotation.Table;

@Entity
@Table(name = "Feature")
public class FeatureDetailEntity extends AbstractEntity {
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "FeatureID")
	private Long featureID;
	
	@Column(name = "Code")
	private String code;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getFeatureID() {
		return featureID;
	}
	public void setFeatureID(Long featureID) {
		this.featureID = featureID;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
