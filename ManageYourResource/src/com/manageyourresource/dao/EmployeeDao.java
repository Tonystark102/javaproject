package com.manageyourresource.dao;

import java.util.HashMap;
import java.util.List;

import com.manageyourresource.dto.Employee;

public interface EmployeeDao {
	public String saveEmployee(Employee obj);
	public HashMap checkuser(int userId,String Password);
	public  Employee getEmployeebyId(int userId );
}


