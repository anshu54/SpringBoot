package com.anshu.basic.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.anshu.basic.model.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	public List<Customer> findByCustomerNameStartingWith(String customerName);
	public List<Customer> findByCustomerMobileNoContains(String customerMobNo);
	public List<Customer> findByCustomerCityNameContains(String cityName);
	public List<Customer> findByCustomerGender(String customerGender);
	
	@Transactional
	@Modifying
	@Query("update Customer c set c.customerName=:N where c.customerId=:I")
	public void updateCustomerName(@Param("N")String customerName, @Param("I")Integer customerId);
	
	@Transactional
	@Modifying
	@Query("update Customer c set c.customerDOB=:D where c.customerId=:I")
	public void updateCustomerDob(@Param("D")Date customerDob, @Param("I")Integer customerId);
	
	@Transactional
	@Modifying
	@Query("update Customer c set c.customerGender=:G where c.customerId=:I")
	public void updateCustomerGender(@Param("G")String customerGender, @Param("I")Integer customerId);
	
	@Transactional
	@Modifying
	@Query("update Customer c set c.customerMobileNo=:M where c.customerId=:I")
	public void updateCustomerMobileNo(@Param("M")String customerMobNo, @Param("I")Integer customerId);
	
	@Transactional
	@Modifying
	@Query("update Customer c set c.customerEmail=:E where c.customerId=:I")
	public void updateCustomerEmailId(@Param("E")String customerEmail, @Param("I")Integer customerId);
	
	@Query("from Customer c where customerEmail=:E")
	public Customer searchByEmailId(@Param("E") String customerEmail);
	
	
	

}
