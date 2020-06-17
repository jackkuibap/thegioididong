package com.laptrinhjavaweb.entity;

import com.laptrinhjavaweb.annotation.Column;
import com.laptrinhjavaweb.annotation.Entity;
import com.laptrinhjavaweb.annotation.Table;

@Entity
@Table(name = "StoreProduct")
public class StoreProductEntity extends AbstractEntity {
	
	@Column(name = "StoreID")
	private Long storeID;
	
	@Column(name = "ProductID")
	private Long productID;
	
	@Column(name = "PhoneColor")
	private String phoneColor;
	
	@Column(name = "Amount")
	private Integer amount;
	
	public Long getStoreID() {
		return storeID;
	}
	public void setStoreID(Long storeID) {
		this.storeID = storeID;
	}
	public Long getProductID() {
		return productID;
	}
	public void setProductID(Long productID) {
		this.productID = productID;
	}
	public String getPhoneColor() {
		return phoneColor;
	}
	public void setPhoneColor(String phoneColor) {
		this.phoneColor = phoneColor;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}

}
