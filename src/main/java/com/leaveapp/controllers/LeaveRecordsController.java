package com.leaveapp.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.leaveapp.dao.EmployeeImplDao;
import com.leaveapp.dao.LeaveRecordImplDao;
import com.leaveapp.models.Employee;
import com.leaveapp.models.LeaveRecord;

@Controller
public class LeaveRecordsController {

	@Autowired
	public LeaveRecordImplDao leaveRecordDao;

	@Autowired
	public EmployeeImplDao employeeDao;

	ModelAndView modelAndView = new ModelAndView();

	@RequestMapping("/add-leave-record")
	public String addLeaveRecord(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int daysCarriedForward = Integer.parseInt(request.getParameter("carried_forward"));
		int currentYearLeaveDays = 24;
		int totalLeaveDays = daysCarriedForward + currentYearLeaveDays;
		int remainingLeaveDays = currentYearLeaveDays + daysCarriedForward;
		int employeeId = Integer.parseInt(request.getParameter("employee_id"));

		Employee employee = employeeDao.getEmployeeById(employeeId);
		String email = employee.getEmail();
		boolean status = false;
		List<LeaveRecord> leaveRecords = null;

		// Check if the record with such employee exists
		LeaveRecord leaveRecord = null;
		leaveRecord = leaveRecordDao.getLeaveRecordByEmployeeId(employeeId);
		try {
			if (leaveRecord == null) {
				status = leaveRecordDao.createLeaveRecord(new LeaveRecord(daysCarriedForward, currentYearLeaveDays,
						totalLeaveDays, remainingLeaveDays, employeeId, email));
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
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/admin";
	}
	
}
