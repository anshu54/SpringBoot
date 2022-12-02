package com.anshu.basic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import com.anshu.basic.model.Customer;
import com.anshu.basic.service.CustomerService;
import com.anshu.basic.validation.Validation;

public class CustomerInterfaceImpl implements CustomerInterface {
	private ApplicationContext applicationContext=SpringApplication.run(CompleteSpringBootProjectApplication.class);
	private CustomerService customerService=applicationContext.getBean(CustomerService.class);
	private Scanner scanner=new Scanner(System.in);
	private SimpleDateFormat simpleDateFormat=new SimpleDateFormat("MM/dd/yyyy");
	
	private Integer customerId;
	private String customerName;
	private Date customerDOB;
	private String customerGender;
	private String customerEmail;
	private String customerMobileNo;
	private String customerCityName;
	private String dob;
	private Boolean checkingName;
	private Boolean checkingGender;
	private Boolean checkingEmail;
	private Boolean checkingMobileNo;
	private Boolean checkingDateOfBirth;
	
	@Override
	public void addCustomerRecord() {
		Customer customer=new Customer();
		
		checkingName=true;
		checkingGender=true;
		checkingEmail=true;
		checkingMobileNo=true;
		checkingDateOfBirth=true;
		
		while(checkingName)
		{
			
			System.out.print("Enter Customer Name : ");
			customerName=scanner.next();
			if(Validation.checkNameLength(customerName))
			{
				if(Validation.validateString(customerName))
				{
					customer.setCustomerName(customerName);
					checkingName=false;
					while(checkingDateOfBirth)
					{
						System.out.print("Enter Customer Data of Birth[MM/dd//yyyy] : ");
						dob=scanner.next();
						if(Validation.checkDate(dob,new Date())) 
						{
							try 
							{
							customerDOB=simpleDateFormat.parse(dob);
							} catch (ParseException e) {
								System.out.println(e);
								}
							customer.setCustomerDOB(customerDOB);
							checkingDateOfBirth=false;
							while(checkingGender)
							{
								System.out.print("Enter Customer Gender : ");
								customerGender=scanner.next();
								if(Validation.checkGender(customerGender))
								{
									customer.setCustomerGender(customerGender);
									checkingGender=false;
									while(checkingEmail)
									{
										System.out.print("Enter Customer E-mail Id : ");
										customerEmail=scanner.next();
										if(Validation.checkEmail(customerEmail))
										{
											customer.setCustomerEmail(customerEmail);
											checkingEmail=false;
											while(checkingMobileNo)
											{
												System.out.print("Enter Customer Mobile Number : ");
												customerMobileNo=scanner.next();
												if(Validation.checkMobileNumber(customerMobileNo))
												{
													customer.setCustomerMobileNo(customerMobileNo);
													checkingMobileNo=false;
													System.out.print("Enter Customer City Name : ");
													customerCityName=scanner.nextLine();
													customerCityName=scanner.nextLine();
													customer.setCustomerCityName(customerCityName);
													
													System.out.println("\n"+customerService.addCustomerRecord(customer)+"\n");
												}
												else
												System.out.println("\n***Invalid Mobile Number..\n");
											}
										}
										else
										System.out.println("\n***Invalid Email...\n");
									}
								}
								else
									System.out.println("\n***Invalid Gender.\n");
							}
						}
					else
						System.out.println("\n***Invalid Date.....\n");
					}
				}
				else
				System.out.println("\n***Customer name must be letters...\n");		
			}
			else
				System.out.println("\n***Customer name length must be less then 15 ...\n");
		}	
	}

	@Override
	public void updateCustomerRecord() {
		checkingName=true;
		checkingGender=true;
		checkingEmail=true;
		checkingMobileNo=true;
		checkingDateOfBirth=true;
		
		Customer customer=new Customer();
		System.out.print("Enter Customer Id : ");
		customerId=scanner.nextInt();
		
		
		Optional<Customer> lObj=customerService.findCustomerRecordById(customerId);
		if(lObj.isPresent())
		{
		
		customer.setCustomerId(customerId);
		while(checkingName)
		{
			System.out.print("Enter Customer Name : ");
			customerName=scanner.next();
			if(Validation.checkNameLength(customerName))
			{
				if(Validation.validateString(customerName))
				{
					customer.setCustomerName(customerName);
					checkingName=false;
					while(checkingDateOfBirth)
					{
						System.out.print("Enter Customer DataOfBirth[MM/dd//yyyy] : ");
						dob=scanner.next();
						if(Validation.checkDate(dob,new Date())) 
						{
							try 
							{
							customerDOB=simpleDateFormat.parse(dob);
							} catch (ParseException e) {
								System.out.println(e);
								}
							customer.setCustomerDOB(customerDOB);
							checkingDateOfBirth=false;
							while(checkingGender)
							{
								System.out.print("Enter Customer Gender : ");
								customerGender=scanner.next();
								if(Validation.checkGender(customerGender))
								{
									customer.setCustomerGender(customerGender);
									checkingGender=false;
									while(checkingEmail)
									{
										System.out.print("Enter Customer E-mail Id : ");
										customerEmail=scanner.next();
										if(Validation.checkEmail(customerEmail))
										{
											customer.setCustomerEmail(customerEmail);
											checkingEmail=false;
											while(checkingMobileNo)
											{
												System.out.print("Enter Customer Mobile Number : ");
												customerMobileNo=scanner.next();
												if(Validation.checkMobileNumber(customerMobileNo))
												{
													customer.setCustomerMobileNo(customerMobileNo);
													checkingMobileNo=false;
													System.out.print("Enter Customer City Name : ");
													customerCityName=scanner.nextLine();
													customerCityName=scanner.nextLine();
													customer.setCustomerCityName(customerCityName);
													
													System.out.println("\n"+customerService.updateCustomerCompleteRecord(customer)+"\n");
											
												}
												else
													System.out.println("\n***Invalid Mobile Number..\n");
											}
										}
										else
											System.out.println("\n***Invalid Email...\n");
									}
								}
								else
									System.out.println("\n***Invalid Gender.\n");
							}
						}
					else
						System.out.println("\n***Invalid Date...\n");
					}
				}
				else
					System.out.println("\n***Customer name must be letters...\n");		
			}
			else
				System.out.println("\n***Customer name length must be less then 15 ...\n");
		}
		
	}
	else
		System.out.println("\n***Record Not Found***");	
	}

	@Override
	public void updateCustomerName() {
		checkingName=true;
		System.out.print("Enter Customer Id : ");
		customerId=scanner.nextInt();
		
		Optional<Customer> lObj=customerService.findCustomerRecordById(customerId);
		Customer customerOld=lObj.get();
		if(lObj.isPresent())
		{
			while(checkingName)
			{
				System.out.print("Enter Customer Name : ");
				customerName=scanner.next();
				if(Validation.checkNameLength(customerName))
				{
					if(Validation.validateString(customerName))
					{
						Customer customerNew=new Customer();
						customerNew.setCustomerId(customerOld.getCustomerId());
						customerNew.setCustomerCityName(customerOld.getCustomerCityName());
						customerNew.setCustomerDOB(customerOld.getCustomerDOB());
						customerNew.setCustomerGender(customerOld.getCustomerGender());
						customerNew.setCustomerMobileNo(customerOld.getCustomerMobileNo());
						customerNew.setCustomerName(customerName);
						customerNew.setCustomerEmail(customerOld.getCustomerEmail());
						System.out.println("\n"+customerService.updateCustomerCompleteRecord(customerNew)+"\n");
						checkingName=false;
					}
					else
						System.out.println("\n***Customer name must be letters...\n");		
				}
				else
					System.out.println("\n***Customer name length must be less then 15 ...\n");
			}
	}
	else
		System.out.println("\n***Record Not Found***");
		
	}

	@Override
	public void updateCustomerDob() {
		checkingDateOfBirth=true;
		System.out.print("Enter Customer Id : ");
		customerId=scanner.nextInt();
		
		Optional<Customer> lObj=customerService.findCustomerRecordById(customerId);
		if(lObj.isPresent())
		{
			while(checkingDateOfBirth)
			{
				System.out.print("Enter Customer Data of Birth[MM/dd//yyyy] : ");
				dob=scanner.next();
				if(Validation.checkDate(dob,new Date())) 
				{
					try 
					{
					customerDOB=simpleDateFormat.parse(dob);
					} catch (ParseException e) {
						System.out.println(e);
						}
					checkingDateOfBirth=false;
					System.out.println("\n"+customerService.updateCustomerDob(customerDOB, customerId)+"\n");
					
				}
				else
					System.out.println("\n***Invalid Date...\n");
				}
		}
		else
			System.out.println("\n***Record Not Found***");
	}

	@Override
	public void updateCustomerGender() {
		checkingGender=true;
		System.out.print("Enter Customer Id : ");
		customerId=scanner.nextInt();
		
		Optional<Customer> lObj=customerService.findCustomerRecordById(customerId);
		if(lObj.isPresent())
		{
			while(checkingGender)
			{
				System.out.print("Enter Customer Gender : ");
				customerGender=scanner.next();
				if(Validation.checkGender(customerGender))
				{
					System.out.println("\n"+customerService.updateCustomerGender(customerGender, customerId)+"\n");
					checkingGender=false;
				}
				else
					System.out.println("\n***Invalid Gender.\n");
			}	
		}
		else
			System.out.println("\n***Record Not Found***");
	}

	@Override
	public void updateCustomerEmailId() {
		checkingEmail=true;
		System.out.print("Enter Customer Id : ");
		customerId=scanner.nextInt();
		
		Optional<Customer> lObj=customerService.findCustomerRecordById(customerId);
		if(lObj.isPresent())
		{
			while(checkingEmail)
			{
				System.out.print("Enter Customer E-mail Id : ");
				customerEmail=scanner.next();
				if(Validation.checkEmail(customerEmail))
				{
					checkingEmail=false;
					System.out.println("\n"+customerService.updateCustomerEmail(customerEmail, customerId)+"\n");
				}
				else
					System.out.println("\n***Invalid Email...\n");
			}
		}
		else
			System.out.println("\n***Record Not Found***");
	}

	@Override
	public void updateCustomerMobNo() {
		checkingMobileNo=true;
		System.out.print("Enter Customer Id : ");
		customerId=scanner.nextInt();
		
		Optional<Customer> lObj=customerService.findCustomerRecordById(customerId);
		if(lObj.isPresent())
		{
			while(checkingMobileNo)
			{
				System.out.print("Enter Customer Mobile Number : ");
				customerMobileNo=scanner.next();
				if(Validation.checkMobileNumber(customerMobileNo))
				{
					checkingMobileNo=false;
					System.out.println("\n"+customerService.updateCustomerMobileNo(customerMobileNo, customerId)+"\n");
				}
				else
					System.out.println("\n***Invalid Mobile Number..\n");
			}
		}
		else
			System.out.println("\n***Record Not Found***");
	}

	@Override
	public void removeCustomerRecord() {
		System.out.print("\nEnter Customer Id :");
		customerId=scanner.nextInt();
		Optional<Customer> lObj=customerService.findCustomerRecordById(customerId);
		if(lObj.isPresent())
		{
			System.out.println("\n"+customerService.deleteCustomerRecord(customerId)+"\n");
		}
		else
		{
			System.out.println("\n ***Record Not Found***");
		}

		
	}

	@Override
	public void findCustomerRecordById() {
		System.out.print("\nEnter Customer Id: ");
		customerId=scanner.nextInt();
		
		Optional<Customer> lObj=customerService.findCustomerRecordById(customerId);
		if(lObj.isPresent()) {
			Customer c=lObj.get();
			System.out.println("---------------------------------------------");
			System.out.println("Customer No is 			: "+c.getCustomerId());
			System.out.println("Customer Name is 		: "+c.getCustomerName());
			System.out.println("Customer Salary is 		: "+c.getCustomerDOB());
			System.out.println("Customer Gender is 		: "+c.getCustomerGender());
			System.out.println("Customer Email is 		: "+c.getCustomerEmail());
			System.out.println("Customer Mobile Number is 	: "+c.getCustomerMobileNo());
			System.out.println("Customer City is 		: "+c.getCustomerCityName());
			System.out.println("----------------------------------------------");
		
		}
		else
			System.out.println("\n ***Record Not Found***");

		
	}

	@Override
	public void findCustomerRecordByName() {
		System.out.print("\nEnter Customer Name: ");
		customerName=scanner.next();
		
		List<Customer> customerList=customerService.findByCustomerName(customerName);
		if(customerList.size()!=0) {
			System.out.println("**********************************************************************************************");
			System.out.println("customerId\tName\t\tDateOfBirth\tGender\tEmail\t\tMobileNo\tCity");
			customerList.forEach(c->
			{
				System.out.println(c.getCustomerId()+"\t\t"+c.getCustomerName()+"\t\t"+c.getCustomerDOB()+"\t"+c.getCustomerGender()+"\t"+c.getCustomerEmail()+"\t"+c.getCustomerMobileNo()
				+"\t"+c.getCustomerCityName());
			});
			System.out.println("***********************************************************************************************");
			
		}
		else
			System.out.println("\n ***Record Not Found***");
		
	}

	@Override
	public void findCustomerRecordByEmail() {
		System.out.print("\nEnter Customer Email: ");
		customerEmail=scanner.next();
		
		Customer customer=customerService.findByCustomerEmailId(customerEmail);
		if(customer!=null) {
			
			System.out.println("---------------------------------------------");
			System.out.println("Customer No is 			: "+customer.getCustomerId());
			System.out.println("Customer Name is 		: "+customer.getCustomerName());
			System.out.println("Customer Salary is 		: "+customer.getCustomerDOB());
			System.out.println("Customer Gender is 		: "+customer.getCustomerGender());
			System.out.println("Customer Email is 		: "+customer.getCustomerEmail());
			System.out.println("Customer Mobile Number is 	: "+customer.getCustomerMobileNo());
			System.out.println("Customer City is 		: "+customer.getCustomerCityName());
			System.out.println("----------------------------------------------");
		
		}
		else
			System.out.println("\n***Record Not Found***");
	
		
	}

	@Override
	public void findCustomerRecordByMobileNo() {
		System.out.print("\nEnter Customer Mobile No: ");
		customerMobileNo=scanner.next();
		
		List<Customer> customer=customerService.findByMobileNo(customerMobileNo);
		if(customer.size()!=0) {
			System.out.println("**********************************************************************************************");
			System.out.println("customerId\tName\t\tDateOfBirth\tGender\tEmail\t\tMobileNo\tCity");
			customer.forEach(c->
			{
				System.out.println(c.getCustomerId()+"\t\t"+c.getCustomerName()+"\t\t"+c.getCustomerDOB()+"\t"+c.getCustomerGender()+"\t"+c.getCustomerEmail()+"\t"+c.getCustomerMobileNo()
				+"\t"+c.getCustomerCityName());
			});
			System.out.println("***********************************************************************************************");
			
		}
		else
			System.out.println("\n ***Record Not Found***");	
	}

	@Override
	public void findCustomerByCityName() {
		System.out.print("\nEnter Customer City Name: ");
		customerCityName=scanner.next();
		List<Customer> customerList=customerService.findByCityName(customerCityName);
		if(customerList.size()!=0) {
			System.out.println("**********************************************************************************************");
			System.out.println("customerId\tName\t\tDateOfBirth\tGender\tEmail\t\tMobileNo\tCity");
			customerList.forEach(c->
			{
				System.out.println(c.getCustomerId()+"\t\t"+c.getCustomerName()+"\t\t"+c.getCustomerDOB()+"\t"+c.getCustomerGender()+"\t"+c.getCustomerEmail()+"\t"+c.getCustomerMobileNo()
				+"\t"+c.getCustomerCityName());
			});
			System.out.println("***********************************************************************************************");
			
		}
		else
			System.out.println("\n ***Record Not Found***");
		
	}

	@Override
	public void findCustomerByGender() {
		System.out.print("\nEnter Customer Gender: ");
		customerGender=scanner.next();
		List<Customer> customerList=customerService.findByGender(customerGender);
		if(customerList.size()!=0) {
			System.out.println("**********************************************************************************************");
			System.out.println("customerId\tName\t\tDateOfBirth\tGender\tEmail\t\tMobileNo\tCity");
			customerList.forEach(c->
			{
				System.out.println(c.getCustomerId()+"\t\t"+c.getCustomerName()+"\t\t"+c.getCustomerDOB()+"\t"+c.getCustomerGender()+"\t"+c.getCustomerEmail()+"\t"+c.getCustomerMobileNo()
				+"\t"+c.getCustomerCityName());
			});
			System.out.println("***********************************************************************************************");
			
		}
		else
			System.out.println("\n ***Record Not Found***");
		
	}
	
}
