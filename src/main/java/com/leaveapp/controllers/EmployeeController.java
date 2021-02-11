package com.leaveapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.leaveapp.dao.EmployeeImplDao;
import com.leaveapp.models.Employee;

/*
 * @author: joshedewa@gmail.com
 * @version: 0.1.0
 * @since: 09-02-2021
 * 
 */
@Controller
public class EmployeeController {
	
	@Autowired
	@Lazy
	public EmployeeImplDao employeeDao;
	
	ModelAndView modelAndView = new ModelAndView();
	
	@RequestMapping("/add-employee")
	public String addEmployee() {
		List<Employee> employees = null;
		boolean status = false;
		
		status = employeeDao.createEmployee(new Employee("hjghhghg", "gfgfghgh", "fggfhgfghfsd"));
		if(status == true) {
			employees = employeeDao.getAllEmployees();
			modelAndView.setViewName("dashboard.jsp");
			modelAndView.addObject("employees", employees);
			System.out.println("Creating Employee Success");
		}
		else {
			employees = employeeDao.getAllEmployees();
			modelAndView.setViewName("dashboard.jsp");
			modelAndView.addObject("employees", employees);
			System.out.println("Creating Employee Failed");
		}
		return "redirect:/admin";
	}
	
	@RequestMapping("/add-leave-record")
	public String addLeaveRecord() {
		modelAndView.setViewName("dashboard.jsp");
		return "redirect:/admin";
	}
}
