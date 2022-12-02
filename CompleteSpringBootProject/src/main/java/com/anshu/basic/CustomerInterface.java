package com.anshu.basic;

public interface CustomerInterface {
	
	public void addCustomerRecord();
	
	public void updateCustomerRecord();
	public void updateCustomerName();
	public void updateCustomerDob();
	public void updateCustomerGender();
	public void updateCustomerEmailId();
	public void updateCustomerMobNo();
	
	public void removeCustomerRecord();
	
	public void findCustomerRecordById();
	public void findCustomerRecordByName();
	public void findCustomerRecordByEmail();
	public void findCustomerRecordByMobileNo();
	public void findCustomerByCityName();
	public void findCustomerByGender();
	
}
