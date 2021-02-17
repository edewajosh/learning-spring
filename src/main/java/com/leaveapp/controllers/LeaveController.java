package com.leaveapp.controllers;
/*
 * @author: joshedewa@gmail.com
 * @version: 0.1.0
 * @since: 09-02-2021
 * 
 */
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.leaveapp.dao.ActiveLeaveImplDao;
import com.leaveapp.dao.EmployeeImplDao;
import com.leaveapp.models.ActiveLeave;
import com.leaveapp.models.Employee;

@Controller
public class LeaveController {
	
	@Autowired
	private EmployeeImplDao employeeDao;
	
	@Autowired
	private ActiveLeaveImplDao activeLeaveDao;
	
	ModelAndView modelAndView = new ModelAndView();
	
	@RequestMapping("/index")
	public ModelAndView index() {
		modelAndView.setViewName("index.jsp");
		return modelAndView;
	}
	
	@RequestMapping("/login-supervisor")
	public ModelAndView loginSupervisor() {
		modelAndView.setViewName("supervisor.jsp");
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		modelAndView.addObject("year", year);
		return modelAndView;
	}
	
	@RequestMapping("/admin")
	public ModelAndView adminDashboard() {
		List<Employee> employees = employeeDao.getAllEmployees();
		List<ActiveLeave>leaves = activeLeaveDao.getAllActiveLeaves();
		modelAndView.setViewName("dashboard.jsp");
		UUID uuid=UUID.randomUUID();
		modelAndView.addObject("staffId", uuid);
		modelAndView.addObject("employees", employees);
		modelAndView.addObject("leaves", leaves);
		return modelAndView;
	}
	
	@RequestMapping("/leave")
	public ModelAndView applyLeave() {
		modelAndView.setViewName("leave.jsp");
		return modelAndView;
	}
}
