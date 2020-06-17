package com.laptrinhjavaweb.dto;

public class FeatureDetailDTO extends AbstractDTO{
	
	private String name;
	private Long featureID;
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
