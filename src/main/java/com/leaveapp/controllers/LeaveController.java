package com.leaveapp.controllers;
/*
 * @author: joshedewa@gmail.com
 * @version: 0.1.0
 * @since: 09-02-2021
 * 
 */
import java.sql.Date;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.leaveapp.models.LeaveRecord;

@Controller
public class LeaveController {
	
	ModelAndView modelAndView = new ModelAndView();
	
	@RequestMapping("/index")
	public ModelAndView index() {
		modelAndView.setViewName("index.jsp");
		System.out.println("Hello Leave Approval");
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
		modelAndView.setViewName("dashboard.jsp");
		UUID uuid=UUID.randomUUID();
		System.out.println(uuid);
		modelAndView.addObject("staffId", uuid);
		return modelAndView;
	}
}
