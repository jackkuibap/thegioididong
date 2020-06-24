package com.laptrinhjavaweb.api.input;

public class ProductInput {
	private String name;
	private String color;
	private String code;
	private String costFrom;
	private String costTo;
	private String[] features = new String[] {};
	private String brand;
	private Long storeID;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCostFrom() {
		return costFrom;
	}
	public void setCostFrom(String costFrom) {
		this.costFrom = costFrom;
	}
	public String getCostTo() {
		return costTo;
	}
	public void setCostTo(String costTo) {
		this.costTo = costTo;
	}
	public String[] getFeatures() {
		return features;
	}
	public void setFeatures(String[] features) {
		this.features = features;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Long getStoreID() {
		return storeID;
	}
	public void setStoreID(Long storeID) {
		this.storeID = storeID;
	}
	
}
