package com.anshu.basic.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer customerId;
	
	@Column(name="Name")
	private String customerName;
	
	@Column(name="DateOfBirth")
	@Temporal(TemporalType.DATE)
	private Date customerDOB;
	
	@Column(name="Gender")
	private String customerGender;
	
	@Column(name="Email")
	private String customerEmail;
	
	@Column(name="MobileNo")
	private String customerMobileNo;
	
	@Column(name="City")
	private String customerCityName;
	
	
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Date getCustomerDOB() {
		return customerDOB;
	}
	public void setCustomerDOB(Date customerDOB) {
		this.customerDOB = customerDOB;
	}
	public String getCustomerGender() {
		return customerGender;
	}
	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerMobileNo() {
		return customerMobileNo;
	}
	public void setCustomerMobileNo(String customerMobileNo) {
		this.customerMobileNo = customerMobileNo;
	}
	public String getCustomerCityName() {
		return customerCityName;
	}
	public void setCustomerCityName(String customerCityName) {
		this.customerCityName = customerCityName;
	}
	
	
}
