package com.manageyourresource.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import com.manageyourresource.dto.Address;
import com.manageyourresource.dto.Employee;
import com.manageyourresource.dto.SalaryDetails;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public String saveEmployee(Employee obj) {
		// TODO Auto-generated method stub
		System.out.println("employee"+obj.getEmpDept());
		Connection conn=getDBConnection();
		System.out.println("Connection is "+conn);
		
		
		
		
		PreparedStatement stmt;
		try {
			
			stmt = conn.prepareStatement("insert into Employee values(?,?,?,?,?,?,?)");
			stmt.setInt(1,obj.getEmpId());//1 specifies the first parameter in the query  
			stmt.setString(2,obj.getEmpFname());
			stmt.setString(3,obj.getEmpLname());
			
			stmt.setString(4,obj.getEmpRole());
			stmt.setInt(5,obj.getEmpSalary());
			stmt.setString(6,obj.getEmpDept());
			stmt.setString(7,obj.getPassword());
			  
			int i=stmt.executeUpdate();  
			System.out.println(i+" records inserted");  
			stmt = conn.prepareStatement("insert into Address values(?,?,?,?,?,?)");
			stmt.setInt(1,obj.getEmpId());//1 specifies the first parameter in the query  
			stmt.setString(2,obj.getEmpFname()+" "+obj.getEmpLname());
			
			
			stmt.setString(3,obj.getAddress().getCity());
			stmt.setString(4,obj.getAddress().getState());
			stmt.setInt(5,obj.getAddress().getHouseNo());
			stmt.setInt(6,obj.getAddress().getPincode());
			  
			int p=stmt.executeUpdate();  
			System.out.println(p+" records inserted"); 
			
			stmt=conn.prepareStatement("insert into slary values(?,?,?,?,?,?,?,?,?,?)");
			stmt.setInt(1,obj.getEmpId());
			stmt.setInt(2, obj.getSalaryDetails().getHouseRentAllowances());
			stmt.setInt(3, obj.getSalaryDetails().getConveyanceAllowances());
			stmt.setInt(4, obj.getSalaryDetails().getMedicalAllowances());
			stmt.setInt(5, obj.getSalaryDetails().getSpecialAllowances());
			stmt.setInt(6, obj.getSalaryDetails().getGrossSalary());
			stmt.setInt(7, obj.getSalaryDetails().getTds());
			stmt.setInt(8, obj.getSalaryDetails().getHealthInsurance());
			stmt.setInt(9, obj.getSalaryDetails().getNetPay());
			stmt.setInt(10, obj.getSalaryDetails().getTotalDeduction());
			
			int q=stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		
		
		System.out.println("connection is :"+conn);
		return null;
	}
	public Connection getDBConnection()
	{
	Connection conn = null;
	try {
	    // db parameters
	    String url       = "jdbc:mysql://localhost:3306/hrm";
	    String user      = "root";
	    String password  = "root";
		
	    // create a connection to the database
	    conn = DriverManager.getConnection(url, user, password);
	    // more processing here
	    // ...	
	    return conn;
	} catch(SQLException e) {
	   System.out.println(e.getMessage());
	} finally {
		
	}
	return null;
	}
	@Override
	public HashMap checkuser(int userId, String Password) {
		// TODO Auto-generated method stub
		PreparedStatement stmt;
		Connection conn=getDBConnection();
		HashMap map=new HashMap();
		try {
			
			stmt = conn.prepareStatement("Select EmployeeFirstName,EmployeeLastName,EmployeeRole from Employee where EmpId =? and Password=?");
			stmt.setInt(1,userId);//1 specifies the first parameter in the query  
			stmt.setString(2,Password);
			
			
			ResultSet res=stmt.executeQuery();
			
			  while (res.next()) { String empFirstName = res.getString("EmployeeFirstName");
			  
			  String empLastName=res.getString("EmployeeLastName");
			  String role=res.getString("EmployeeRole");
			  map.put("name", empFirstName+" "+empLastName);
			  map.put("role", role);
			  map.put("valid", "valid");
			  	return map;
			  }
			 
			if(!res.next())
			{
				map.put("valid", "invalid");
				return map;
			}
			
			//System.out.println("st->"+rs+"gygjhj"+st.getFetchSize()+" asdfg"+st.getRow());
			
		}
		catch(Exception e)
		{
			System.out.println("Exception is "+e);
			
		}

		return map;
	}
	@Override
	public Employee getEmployeebyId(int userId) {
		// TODO Auto-generated method stub
		PreparedStatement stmt;
		Connection conn = getDBConnection();
		
		try {
			stmt = conn.prepareStatement("Select EmployeeFirstName,EmpId,EmployeeLastName,EmployeeRole ,EmployeeSalary,EmployeeDept from Employee where EmpId =? ");
		
			stmt.setInt(1,userId);
			
			ResultSet res=stmt.executeQuery();
			Employee emp =new Employee();
			
			  while (res.next()) { 
				  String empFirstName = res.getString("EmployeeFirstName");
				  emp.setEmpFname(empFirstName);
				  int empSalary=res.getInt("EmployeeSalary");
				  emp.setEmpSalary(empSalary);
				  String empDept=res.getString("EmployeeDept");
				  emp.setEmpDept(empDept);
				  int empId=res.getInt("EmpId");
				  emp.setEmpId(empId);
				  String empLastName=res.getString("EmployeeLastName");
				  emp.setEmpLname(empLastName);
				  String role=res.getString("EmployeeRole");
				  emp.setEmpRole(role);
		}
			  Address address=new Address();
			
			  stmt = conn.prepareStatement("Select Name,City,State ,HouseNo,Pincode from Address where EmpId =?");
				
				stmt.setInt(1,userId);
				
				ResultSet resa=stmt.executeQuery();
				
				  while (resa.next()) { 
					  System.out.println("jjihh:"+resa.getString("Name"));
					  String FirstName = resa.getString("Name");
					  address.setName(FirstName);
					  String City=resa.getString("City");
					  address.setCity(City);
					  String State=resa.getString("State");
					  address.setState(State);
					  int houseno=resa.getInt("HouseNo");
					  address.setHouseNo(houseno);
					  int pincode=resa.getInt("Pincode");
					  address.setPincode(pincode);
					 
			}
				  
				  stmt = conn.prepareStatement("Select HouseRentAllowances,ConveyanceAllowances,MedicalAllowances ,SpecialAllowances,"
				  		+ "GrossSalary,tds,healthInsurance,netPay,totalDeduction from Slary where EmpId =?");
					
					stmt.setInt(1,userId);
					
					SalaryDetails sd=new SalaryDetails();
					
					ResultSet rest=stmt.executeQuery();
					  while (rest.next()) { 
						  
						  int houseRentAllowances = rest.getInt("HouseRentAllowances");
						  sd.setHouseRentAllowances(houseRentAllowances);
						 
						  int ConveyanceAllowances=rest.getInt("ConveyanceAllowances");
						  sd.setConveyanceAllowances(ConveyanceAllowances);
						  
						  int MedicalAllowances=rest.getInt("MedicalAllowances");
						  sd.setMedicalAllowances(MedicalAllowances);
						 
						  int SpecialAllowances=rest.getInt("SpecialAllowances");
						  sd.setSpecialAllowances(SpecialAllowances);
						  
						  int GrossSalary=rest.getInt("GrossSalary");
						  sd.setGrossSalary(GrossSalary);
						  int tds=rest.getInt("tds");
						  sd.setTds(tds);
						  int healthInsurance=rest.getInt("healthInsurance");
						  sd.setHealthInsurance(healthInsurance);
						  int netPay=rest.getInt("netPay");
						  sd.setNetPay(netPay);
						  int totalDeduction=rest.getInt("totalDeduction");
						  System.out.println("totalDeduction"+totalDeduction);
						  sd.setTotalDeduction(totalDeduction);

						 
						 
				}

					  	emp.setAddress(address);
					  	emp.setSalaryDetails(sd);

						  return emp;
		}
		catch(Exception e)
		{
			System.out.println("Exception occured"+e);
			return null;
		}
		
		
		
		
		
	}
	}
