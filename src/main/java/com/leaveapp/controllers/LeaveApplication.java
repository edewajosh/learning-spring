package com.leaveapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LeaveApplication {
	
	ModelAndView modelAndView = new ModelAndView();
	
	@RequestMapping("/leave-form")
	public ModelAndView searchStaffId() {
		modelAndView.setViewName("application-form.jsp");
		return modelAndView;
	}
}
