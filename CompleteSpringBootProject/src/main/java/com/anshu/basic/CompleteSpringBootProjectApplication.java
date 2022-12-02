package com.anshu.basic;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CompleteSpringBootProjectApplication {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		CustomerInterfaceImpl userInterfaceImp=new CustomerInterfaceImpl();
		Integer choice=null;
		do
		{
			System.out.println("\n***********************************");
			System.out.println("     Customer Information    ");
			System.out.println("***********************************");
		
			System.out.println("1. Add 	Customer Record.    ");
			System.out.println("2. Update Customer Record.  ");
			System.out.println("3. Delete Customer Record.  ");
			System.out.println("4. Find Customer Record.    ");
			System.out.println("5. Exit.");
		
			System.out.print("\nEnter your Choice : ");
			choice=scanner.nextInt();
			System.out.println("--------------------");
		
		switch(choice)
		{
			case 1:
				userInterfaceImp.addCustomerRecord();
				break;
			case 2:
				do {
					System.out.println("\n*******************************");
					System.out.println("    Update Customer Record :    ");
					System.out.println("********************************");
					
					System.out.println("1. Update Complete Customer Record.   ");
					System.out.println("2. Update Customer Name.              ");
					System.out.println("3. Update Customer DateOfBirth.              ");
					System.out.println("4. Update Customer Gender.              ");
					System.out.println("5. Update Customer Email.             ");
					System.out.println("6. Update Customer Mobile Number.     ");
					System.out.println("7. Exit ");
				
					System.out.print("Enter any option :");
					Integer option=scanner.nextInt();
					System.out.println("-----------------");
					switch(option)
					{
						case 1:
							userInterfaceImp.updateCustomerRecord();
							break;
						case 2:
							userInterfaceImp.updateCustomerName();
							//userInterfaceImp.updateCustomerRecord();
							break;
						case 3:
							userInterfaceImp.updateCustomerDob();
							break;
						case 4:
							userInterfaceImp.updateCustomerGender();
							break;
						case 5:
							userInterfaceImp.updateCustomerEmailId();
							break;
						case 6:
							userInterfaceImp.updateCustomerMobNo();
							break;
						case 7:
							System.out.println("\nExit.");
							break;
						default:
							System.out.println("Invalid Number.");
					}
				}while(choice==7);
				break;
			case 3:
				userInterfaceImp.removeCustomerRecord();
				break;
			case 4:
				do {
					System.out.println("\n*******************************");
					System.out.println("    Find Customer Record :    ");
					System.out.println("********************************");
					
					System.out.println("1. Find By Customer Id.           ");
					System.out.println("2. Find By Customer Name.         ");
					System.out.println("3. Find By Customer Email.        ");
					System.out.println("4. Find By Customer Mobile Number.");
					System.out.println("5. Find By City Name.             ");
					System.out.println("6. Find By Customer Gender.       ");
					System.out.println("7. Exit ");
				
					System.out.print("Enter any option :");
					Integer option=scanner.nextInt();
					System.out.println("-----------------");
					switch(option)
					{
						case 1:
							userInterfaceImp.findCustomerRecordById();
							
							break;
						case 2:
							userInterfaceImp.findCustomerRecordByName();
							break;
						case 3:
							userInterfaceImp.findCustomerRecordByEmail();
							break;
						case 4:
							userInterfaceImp.findCustomerRecordByMobileNo();
							break;
						case 5:
							userInterfaceImp.findCustomerByCityName();
							break;
						case 6:
							userInterfaceImp.findCustomerByGender();
							break;
						case 7:
							System.out.println("\nExit.");
							break;
						default:
							System.out.println("Invalid Number.");
					}
				}while(choice==7);
				break;
			case 5:
				System.out.println("User does not want to continue... ");
				break;
			default:
				System.out.println("Invalid Number...");
		}
	}while(choice!=5);
		scanner.close();

	}

}
