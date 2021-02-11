package com.leaveapp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.leaveapp.models.Employee;
import com.leaveapp.utils.LeaveUtils;

@Component
public class EmployeeImplDao implements IEmployee {

	public boolean createEmployee(Employee employee) {
		boolean status = false;
		SqlSession session = LeaveUtils.getSqlSessionFactory().openSession();
		try {
			session.insert("Employee.createEmployee", employee);
			session.commit();
			status = true;
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public Employee getEmployeeById(Employee employee) {
		return null;
	}

	public List<Employee> getAllEmployees() {
		List<Employee> employees = null;
		SqlSession session = LeaveUtils.getSqlSessionFactory().openSession();
		try {
			employees = session.selectList("Employee.getAllEmployees");
			session.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employees;
	}

	public boolean updateEmployee(Employee employee) {
		return false;
	}

	public boolean deleteEmployeeById(int id) {
		return false;
	}

	public boolean deleteAllEmployees() {
		return false;
	}

}
