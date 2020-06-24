package com.laptrinhjavaweb.entity;

import java.util.Date;

import com.laptrinhjavaweb.annotation.Column;
import com.laptrinhjavaweb.annotation.Entity;

public class AbstractEntity {
	
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "CreateDate")
	private Date createDate;
	
	@Column(name = "ModifiedDate")
	private Date modifiedDate;
	
	@Column(name = "CreateBy")
	private String createdBy;
	
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
}
