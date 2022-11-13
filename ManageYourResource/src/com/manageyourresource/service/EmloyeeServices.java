package com.manageyourresource.service;

import java.util.HashMap;


import com.manageyourresource.dto.Employee;

public interface EmloyeeServices {
	public  String registerEmployee(Employee obj);
	public HashMap validateUser(int userId,String password);
	public  Employee findEmployeebyId(int userId );

}
