package com.anshu.basic.service;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anshu.basic.dao.CustomerRepository;
import com.anshu.basic.model.Customer;

@Service
public class CustomerService implements ICustomerService{
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public String addCustomerRecord(Customer customer) {
		customerRepository.saveAndFlush(customer);
		return "Customer Record Added..";
	}

	@Override
	public String updateCustomerCompleteRecord(Customer customer) {
		customerRepository.saveAndFlush(customer);
		return "Customer Record Updated..";
	}

	@Override
	public String updateCustomerName(String customerName,Integer customerId) {
		customerRepository.updateCustomerName(customerName, customerId);
		return "Customer Name Updated";
	}

	@Override
	public String updateCustomerDob(Date customerDob, Integer customerId) {
		customerRepository.updateCustomerDob(customerDob, customerId);
		return "Customer DataOfBirth Updated";
	}

	@Override
	public String updateCustomerGender(String customerGender, Integer customerId) {
		customerRepository.updateCustomerGender(customerGender, customerId);
		return "Customer Gender Updated";
	}

	@Override
	public String updateCustomerEmail(String customerEmail, Integer customerId) {
		customerRepository.updateCustomerEmailId(customerEmail, customerId);
		return "Customer EmailId Updated";
	}

	@Override
	public String updateCustomerMobileNo(String customerMobNo, Integer customerId) {
		customerRepository.updateCustomerMobileNo(customerMobNo, customerId);
		return "Customer Mobile No Updated";
	}

	@Override
	public String deleteCustomerRecord(Integer customerId) {
		customerRepository.deleteById(customerId);
		return "Customer Record Deleted..";
	}
	
	@Override
	public List<Customer> findByCustomerName(String customerName) {
		List<Customer> customer=customerRepository.findByCustomerNameStartingWith(customerName);
		return customer;
	}

	@Override
	public Optional<Customer> findCustomerRecordById(Integer customerId) {
		Optional<Customer> customer=customerRepository.findById(customerId);
		return customer;
	}
	

	@Override
	public Customer findByCustomerEmailId(String customerEmail) {
		Customer customer=customerRepository.searchByEmailId(customerEmail);
		return customer;
	}

	@Override
	public List<Customer> findByMobileNo(String customerMobNo) {
		List<Customer> customer=customerRepository.findByCustomerMobileNoContains(customerMobNo);
		return customer;
	}

	@Override
	public List<Customer> findByCityName(String cityName) {
		List<Customer> customer=customerRepository.findByCustomerCityNameContains(cityName);
		return customer;
	}

	@Override
	public List<Customer> findByGender(String Gender) {
		List<Customer> customer=customerRepository.findByCustomerGender(Gender);
		return customer;
	}
	
}
