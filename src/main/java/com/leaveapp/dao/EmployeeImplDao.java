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

	public Employee getEmployeeById(Integer id) {
		SqlSession session = LeaveUtils.getSqlSessionFactory().openSession();
		Employee employee = null;
		try {
			employee = session.selectOne("Employee.getEmployeeById", id);
			session.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
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
		SqlSession session = LeaveUtils.getSqlSessionFactory().openSession();
		boolean status = false;
		try {
			session.update("Employee.updateEmployee", employee);
			session.commit();
			status= true;
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}

	public boolean deleteEmployeeById(int id) {
		SqlSession session = LeaveUtils.getSqlSessionFactory().openSession();
		boolean status = false;
		try {
			session.delete("Employee.deleteEmployeeById", id);
			session.commit();
			status= true;
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}

	public boolean deleteAllEmployees() {
		SqlSession session = LeaveUtils.getSqlSessionFactory().openSession();
		boolean status = false;
		try {
			session.delete("Employee.deleteAllEmployees");
			session.commit();
			status= true;
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
