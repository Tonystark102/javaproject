package com.manageyourresource;

import java.util.HashMap;
import java.util.Scanner;

import com.manageyourresource.dto.Address;
import com.manageyourresource.dto.Employee;
import com.manageyourresource.dto.SalaryDetails;
import com.manageyourresource.service.EmloyeeServices;
import com.manageyourresource.service.EmployeeServiceImpl;

public class ManageYourResource {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       
		Boolean valid=true;
		Scanner sc=new Scanner(System.in);
		
		while(valid)
		{
			System.out.println("Welcome to ManageYourResource");
			System.out.println("1.Login");
			System.out.println("2.About");
			
			
			int selectedService=sc.nextInt();
			
			switch(selectedService)
			{
			case 1:
				login();
				break;
			case 2:
				about();
			}
		}
		
		
	}
	private static void about() {
		// TODO Auto-generated method stub
		System.out.println("Established in 2022");
		System.out.println("Developed by Gautam Kumar");
		System.out.println("Thanks for visiting about page");
		
	}
	private static String registerEmployee()
	{
		 int empId;
		 String password;
		 String empFname;
		 String empLname;
		 String empcity;
		 String empDept;
		 String empstate;
		 int emphouseNo;
		 Address address;
		 int emppincode;
		 String empRole;
		 int empSalary;
		 int houseA ;
		 int healthI = 0;
		 int tds=0;
		 int netPay=0;
		 int convF=0;
		 int grossSalary=0;
		 int medicalA=0;
		 int totalDeduction=0;
		 int specialS = 0;
		 
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Below Details");
		System.out.println("Enter Employee Id");
		empId=sc.nextInt();
		System.out.println("Enter password");
		password=sc.next();
		System.out.println("Enter First name");
		empFname=sc.next();
		System.out.println("Enter Last name");
		empLname=sc.next();
		
		System.out.println("Enter Employee Role");
	
		empRole=sc.next();
		System.out.println("Enter dept");
		empDept=sc.next();
		System.out.println("Enter Employee Salary");
		empSalary=sc.nextInt();
		System.out.println("Enter Employee address");
		
		System.out.println("Enter house No");
		emphouseNo=sc.nextInt();
		System.out.println("Enter city");
		empcity=sc.next();
		System.out.println("Enter state");
		empstate=sc.next();
		
		System.out.println("Enter pincode");
		emppincode=sc.nextInt();
		Employee emp=new Employee();
		emp.setEmpId(empId);
		emp.setEmpFname(empFname);
		emp.setEmpLname(empLname);
		emp.setEmpRole(empRole);
		emp.setEmpDept(empDept);
		emp.setEmpSalary(empSalary);
		SalaryDetails sd=new SalaryDetails();
		System.out.println("Enter house Allowance");
		houseA=sc.nextInt();
		sd.setHouseRentAllowances(houseA);
		System.out.println("Enter healthInsurance");
		healthI=sc.nextInt();
		sd.setHealthInsurance(healthI);
		System.out.println("Enter specialAllowance");
		specialS=sc.nextInt();
		sd.setSpecialAllowances(specialS);
		System.out.println("Enter Medical Allowance");
		medicalA=sc.nextInt();
		sd.setMedicalAllowances(medicalA);	
		System.out.println("Enter conveyance Allowance");
		convF=sc.nextInt();
		sd.setConveyanceAllowances(convF);
		System.out.println("Enter tds");
		tds=sc.nextInt();
		sd.setTds(tds);
		System.out.println("Enter gross salary");
		grossSalary=sc.nextInt();
		sd.setGrossSalary(grossSalary);
		System.out.println("Enter total Deduction");
		totalDeduction=sc.nextInt();
		sd.setTotalDeduction(totalDeduction);
		System.out.println("Enter net pay");
		netPay=sc.nextInt();
		sd.setNetPay(netPay);
		emp.setSalaryDetails(sd);
		 address=new Address();
		address.setCity(empcity);
		address.setHouseNo(emphouseNo);
		address.setPincode(emppincode);
		address.setState(empstate);
		emp.setPassword(password);
		emp.setAddress(address);
		
		EmloyeeServices empService=new EmployeeServiceImpl();
		String status=empService.registerEmployee(emp);

		
		return status;
		
	}
	
   
	public static void login()
	{
		int userId;
		String password;
		Scanner scc=new Scanner(System.in);
		System.out.println("Enter User Id ");
		userId=scc.nextInt();
		System.out.println("Enter Password");
		password=scc.next();
		EmloyeeServices empservice=new EmployeeServiceImpl();
		HashMap flag=empservice.validateUser(userId, password);
		if(flag.get("valid").toString().equalsIgnoreCase("valid"))
		{
			System.out.println("Welcome "+flag.get("name"));
			if(flag.get("role").toString().equalsIgnoreCase("admin"))
			{
				
				int check ;
				System.out.println("1.Register Employee");
				System.out.println("2.Search Employee by Employee Id");
				check =scc.nextInt();
				switch(check)
				{
				case 1:
					registerEmployee();	
					break;
				case 2:
					searchEmployeebyEmpId();
					
				}
			
			
			
			
			}
			
		}
		else 
		{
			System.out.println("Invalid Credentials");
		}
		{
			
		}
		
		
	}
	private static void searchEmployeebyEmpId() {
		// TODO Auto-generated method stub
		
		System.out.println("Enter Employee Id");
		Scanner sr=new Scanner (System.in);
		int EmpId=sr.nextInt();
		EmloyeeServices empService =new EmployeeServiceImpl();
		Employee emp=empService.findEmployeebyId(EmpId);
		System.out.println("Name :"+emp.getEmpFname()+" "+emp.getEmpLname());
		System.out.println("Role :"+emp.getEmpRole());
		System.out.println("Id :"+emp.getEmpId());
		System.out.println("Salary :"+emp.getEmpSalary());
		System.out.println("City :"+emp.getAddress().getCity());
		System.out.println("State :"+emp.getAddress().getState());
		System.out.println("Take Home Salary :"+emp.getSalaryDetails().getNetPay());
		System.out.println("Total Deduction :"+emp.getSalaryDetails().getNetPay());


		
		
	}
	
	

	
	

}
