package com.leaveapp.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.leaveapp.dao.LeaveRecordImplDao;
import com.leaveapp.models.LeaveRecord;

@Controller
public class LeaveRecordsController {

	@Autowired
	public LeaveRecordImplDao leaveRecordDao;

	ModelAndView modelAndView = new ModelAndView();

	@RequestMapping("/add-leave-record")
	public String addLeaveRecord(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int daysCarriedForward = 12;
		int currentYearLeaveDays = 24;
		int totalLeaveDays = 36;
		int remainingLeaveDays = 30;
		int employeeId = Integer.parseInt(request.getParameter("employee_id"));
		boolean status = false;
		List<LeaveRecord> leaveRecords = null;

		status = leaveRecordDao.createLeaveRecord(new LeaveRecord(daysCarriedForward, currentYearLeaveDays,
				totalLeaveDays, remainingLeaveDays, employeeId));
		if (status == true) {
			modelAndView.setViewName("dashboard.jsp");
			leaveRecords = leaveRecordDao.getAllLeaveRecords();
			modelAndView.addObject("leave-records", leaveRecords);
			System.out.println("Leave Record Added Successfuly");
		} else {
			modelAndView.setViewName("dashboard.jsp");
			leaveRecords = leaveRecordDao.getAllLeaveRecords();
			modelAndView.addObject("leave-records", leaveRecords);
			System.out.println("Failed to Add Leave Record");
		}
		return "redirect:/admin";
	}

}
