package com.leaveapp.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
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
	public EmployeeImplDao employeeDao;
	
	ModelAndView modelAndView = new ModelAndView();
	
	@RequestMapping("/add-employee")
	public String addEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String staffId = request.getParameter("staff_id");
		String fullName = request.getParameter("full_name");
		String phoneNumber = request.getParameter("phone_number");
		System.out.println(staffId + " " + fullName + " " + phoneNumber);
		List<Employee> employees = null;
		boolean status = false;
		status = employeeDao.createEmployee(new Employee(fullName, staffId, phoneNumber));
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
}
