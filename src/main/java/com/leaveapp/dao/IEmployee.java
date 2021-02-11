package com.leaveapp.dao;

import java.util.List;

import com.leaveapp.models.Employee;

public interface IEmployee {
	
	public boolean createEmployee(Employee employee);
	public Employee getEmployeeById(Employee employee);
	public List<Employee> getAllEmployees();
	public boolean updateEmployee(Employee employee);
	public boolean deleteEmployeeById(int id);
	public boolean deleteAllEmployees();

}
