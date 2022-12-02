package com.anshu.basic.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.anshu.basic.model.Customer;

public interface ICustomerService {
	
	public String addCustomerRecord(Customer customer);
	
	public String updateCustomerCompleteRecord(Customer customer);
	public String updateCustomerName(String customerName,Integer customerId);
	public String updateCustomerDob(Date customerDob, Integer customerId);
	public String updateCustomerGender(String customerGender, Integer customerId);
	public String updateCustomerEmail(String customerEmail, Integer customerId);
	public String updateCustomerMobileNo(String customerMobNo,Integer customerId);
	
	public String deleteCustomerRecord(Integer customerId);
	
	public Optional<Customer> findCustomerRecordById(Integer customerId);
	public List<Customer> findByCustomerName(String customerName);
	public Customer findByCustomerEmailId(String customerEmail);
	public List<Customer> findByMobileNo(String customerMobNo);
	public List<Customer> findByCityName(String cityName);
	public List<Customer> findByGender(String Gender);
	
	

}
