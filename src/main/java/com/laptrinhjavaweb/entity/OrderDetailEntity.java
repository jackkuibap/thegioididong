package com.laptrinhjavaweb.entity;

import java.sql.Timestamp;

import com.laptrinhjavaweb.annotation.Column;
import com.laptrinhjavaweb.annotation.Entity;
import com.laptrinhjavaweb.annotation.Table;

@Entity
@Table(name = "OrderDetail")
public class OrderDetailEntity extends AbstractEntity{
	
	@Column(name = "UserID")
	private Long userID;
	
	@Column(name = "ProductID")
	private Long productID;
	
	@Column(name = "Code")
	private String code;
	
	@Column(name = "Amount")
	private Integer amount;
	
	@Column(name = "CustomerName")
	private String customerName;
	
	@Column(name = "Sex")
	private Boolean sex;
	
	@Column(name = "District")
	private String district;
	
	@Column(name = "Ward")
	private String ward;
	
	@Column(name = "Street")
	private String street;
	
	@Column(name = "Address")
	private String address;
	
	@Column(name = "PhoneNumber")
	private String phoneNumber;
	
	@Column(name = "ReceiveTime")
	private Timestamp receiveTime;
	
	@Column(name = "Invoice")
	private String invoice;
	
	@Column(name = "DataTranfer")
	private Boolean dataTranfer;
	
	@Column(name = "Payment")
	private String payment;
	
	@Column(name = "MoreColor")
	private String moreColor;
	
	@Column(name = "MorePhone")
	private String morePhone;
	
	@Column(name = "Installment")
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
		return sex;
	}
	public void setSex(Boolean sex) {
		this.sex = sex;
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
