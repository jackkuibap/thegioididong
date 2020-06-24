package com.laptrinhjavaweb.entity;

import com.laptrinhjavaweb.annotation.Column;
import com.laptrinhjavaweb.annotation.Entity;
import com.laptrinhjavaweb.annotation.Table;

@Entity
@Table(name = "Product")
public class ProductEntity extends AbstractEntity {

	@Column(name = "Name")
	private String name;
	
	@Column(name = "Color")
	private String color;
	
	@Column(name = "Code")
	private String code;
	
	@Column(name = "Cost")
	private Integer cost;
	
	@Column(name = "Feature")
	private String feature;

	@Column(name = "ProductCategoryID")
	private Long productCategoryID;
	
	@Column(name = "Description1")
	private String description1;
	
	@Column(name = "Description2")
	private String description2;
	
	@Column(name = "Content")
	private String content;
	
	@Column(name = "Specification")
	private String specification;

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

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public Long getProductCategoryID() {
		return productCategoryID;
	}

	public void setProductCategoryID(Long productCategoryID) {
		this.productCategoryID = productCategoryID;
	}

	public String getDescription1() {
		return description1;
	}

	public void setDescription1(String description1) {
		this.description1 = description1;
	}

	public String getDescription2() {
		return description2;
	}

	public void setDescription2(String description2) {
		this.description2 = description2;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}
	

}
