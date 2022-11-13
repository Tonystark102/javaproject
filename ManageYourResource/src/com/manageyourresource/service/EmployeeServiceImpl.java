package com.manageyourresource.service;

import java.util.HashMap;
import java.util.List;

import com.manageyourresource.dao.EmployeeDao;
import com.manageyourresource.dao.EmployeeDaoImpl;
import com.manageyourresource.dto.Employee;

public  class EmployeeServiceImpl implements EmloyeeServices{

	@Override
	public String registerEmployee(Employee obj) {
		
		EmployeeDao dao=new EmployeeDaoImpl();
		dao.saveEmployee(obj);
		return "success";
	}

	@Override
	public HashMap validateUser(int userId, String password) {
		// TODO Auto-generated method stub
		EmployeeDao empDao=new EmployeeDaoImpl();
		return empDao.checkuser(userId, password);
		
	}

	

	@Override
	public Employee findEmployeebyId(int userId) {
		// TODO Auto-generated method stub
		EmployeeDao da=new EmployeeDaoImpl();
		return da.getEmployeebyId(userId);
	}

}
