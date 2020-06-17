package com.laptrinhjavaweb.dto;

import java.sql.Timestamp;

public class OrderDetailDTO extends AbstractDTO{
	
	private Long userID;
	private Long productID;
	private String code;
	private Integer amount;
	private String customerName;
	private Boolean Sex;
	private String district;
	private String ward;
	private String street;
	private String address;
	private String phoneNumber;
	private Timestamp receiveTime;
	private String invoice;
	private Boolean dataTranfer;
	private String payment;
	private String moreColor;
	private String morePhone;
	private String installment;
	
	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	public Long getProductID() {
		return productID;
	}
	public void setProductID(Long productID) {
		this.productID = productID;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Boolean getSex() {
		return Sex;
	}
	public void setSex(Boolean sex) {
		Sex = sex;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Timestamp getReceiveTime() {
		return receiveTime;
	}
	public void setReceiveTime(Timestamp receiveTime) {
		this.receiveTime = receiveTime;
	}
	public String getInvoice() {
		return invoice;
	}
	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}
	public Boolean getDataTranfer() {
		return dataTranfer;
	}
	public void setDataTranfer(Boolean dataTranfer) {
		this.dataTranfer = dataTranfer;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getMoreColor() {
		return moreColor;
	}
	public void setMoreColor(String moreColor) {
		this.moreColor = moreColor;
	}
	public String getMorePhone() {
		return morePhone;
	}
	public void setMorePhone(String morePhone) {
		this.morePhone = morePhone;
	}
	public String getInstallment() {
		return installment;
	}
	public void setInstallment(String installment) {
		this.installment = installment;
	}
	
}
