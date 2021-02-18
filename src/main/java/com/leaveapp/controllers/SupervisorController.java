package com.leaveapp.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.leaveapp.dao.ActiveLeaveImplDao;
import com.leaveapp.dao.LeaveRecordImplDao;
import com.leaveapp.dao.SupervisorImplDao;
import com.leaveapp.models.ActiveLeave;
import com.leaveapp.models.LeaveRecord;
import com.leaveapp.models.Supervisor;

/*
 * @author: joshedewa@gmail.com
 * @version: 0.1.0
 * @since: 09-02-2021
 * 
 */
@Controller
public class SupervisorController {

	ModelAndView modelAndView = new ModelAndView();

	@Autowired
	private SupervisorImplDao supervisorDao;

	@Autowired
	private ActiveLeaveImplDao leaveDao;
	
	@Autowired
	private LeaveRecordImplDao leaveRecordDao;

	@RequestMapping("/supervisor-login")
	public ModelAndView loginSupervisor(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		List<ActiveLeave> leaves = null;
		Supervisor supervisor = null;
		String message = null;
		
		supervisor = supervisorDao.getSupervisorByEmail(email);
		if (supervisor == null) {
			message = "No Supervisor with that email";
			modelAndView.addObject("message", message);
			modelAndView.setViewName("supervisor.jsp");
		} else {
			String password1 = supervisor.getPassword();
			if (password.compareTo(password1)== 0) {
				leaves = leaveDao.getActiveLeaveBySupervisorId(supervisor.getId());
				modelAndView.addObject("leaves", leaves);
				modelAndView.setViewName("supervisor-dashboard.jsp");
			} else {
				message = "You have put wrong password";
				modelAndView.addObject("message", message);
				modelAndView.setViewName("supervisor.jsp");
			}
		}
		return modelAndView;
	}
	
	@RequestMapping("/approve-leave")
	public String approveLeaveRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Integer id = Integer.parseInt(request.getParameter("id"));
		boolean status = false;
		boolean isApproved = true;
		Integer remainingLeaveDays = null;
		Integer appliedLeaveDays = null;
		Integer currentLeaveDays = null;
		
		ActiveLeave leave = null;
		leave = leaveDao.getLeaveById(id);
		Integer employeeId = leave.getEmployeeId();
		// Update Employee leave record to deduct the remaining days
		LeaveRecord leaveRecord = null;
		leaveRecord = leaveRecordDao.getLeaveRecordByEmployeeId(employeeId);
		currentLeaveDays = leaveRecord.getRemainingLeaveDays();
		
		if(leave.getTypeOfLeave().equals("annual")) {
			appliedLeaveDays = leave.getNumberOfDaysApplied();
			remainingLeaveDays = currentLeaveDays - appliedLeaveDays;
			leaveRecord.setRemainingLeaveDays(remainingLeaveDays);
		}
		
		leave.setApproved(isApproved);
		leave.setStatus("Approved");
		
		status = leaveDao.updateActiveLeave(leave);
		
		if(status == true) {
			leaveRecordDao.updateLeaveRecord(leaveRecord);
			System.out.println(status);
		}else {
			System.out.println(status);
		}
		return "redirect:/supervisor-login";
	}
	
	@RequestMapping("/reject-leave")
	public String rejectLeaveRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Integer id = Integer.parseInt(request.getParameter("id"));
		boolean status = false;
		boolean isApproved = false;
		ActiveLeave activeLeave = leaveDao.getLeaveById(id);
		activeLeave.setApproved(isApproved);
		activeLeave.setStatus("Rejected");
		status = leaveDao.updateActiveLeave(activeLeave);
		if(status == true) {
			System.out.println(status);
		}else {
			System.out.println(status);
		}
		return "redirect:/supervisor-login";
	}

}
