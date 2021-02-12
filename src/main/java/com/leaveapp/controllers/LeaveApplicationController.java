package com.leaveapp.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.leaveapp.dao.ActiveLeaveImplDao;
import com.leaveapp.dao.EmployeeImplDao;
import com.leaveapp.dao.SupervisorImplDao;
import com.leaveapp.models.ActiveLeave;
import com.leaveapp.models.Employee;
import com.leaveapp.models.Supervisor;

@Controller
public class LeaveApplicationController {

	@Autowired
	private EmployeeImplDao employeeDao;
	
	@Autowired
	private ActiveLeaveImplDao activeLeaveDao;
	
	@Autowired
	private SupervisorImplDao supervisorDao;

	ModelAndView modelAndView = new ModelAndView();

	@RequestMapping("/leave-form")
	public ModelAndView searchStaffId(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer staff_id = Integer.parseInt(request.getParameter("staff_id").trim());
		String message = null;
		Employee employee = employeeDao.getEmployeeById(staff_id);
		List<Supervisor> supervisors = supervisorDao.getAllSupervisors();
		if (employee == null) {
			message = "Employee with that ID does not exist, please try again";
			modelAndView.setViewName("leave.jsp");
			modelAndView.addObject("message", message);
			return modelAndView;
		} else {
			modelAndView.addObject("employee", employee);
			modelAndView.addObject("supervisors", supervisors);
			modelAndView.setViewName("application-form.jsp");
			return modelAndView;
		}
	}
	
	@RequestMapping("/leave-request")
	public ModelAndView applyLeave(HttpServletRequest request, HttpServletResponse response) throws Exception{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date today = new Date();
		Date appliedOn = format.parse(format.format(today));
		Date startsOn = format.parse(request.getParameter("starts_on"));
		Date endsOn = format.parse(request.getParameter("starts_on"));
		
		Integer numberOfDaysApplied = Integer.parseInt(request.getParameter("leave_days_applied"));
		String typeOfLeave = request.getParameter("type_of_leave");
		String leavaAddress = request.getParameter("leave_address");
		Integer employeeId = Integer.parseInt(request.getParameter("employee_id"));
		
		Integer supervisorId = Integer.parseInt(request.getParameter("supervisor_id"));
		
		boolean status = false;
		status = activeLeaveDao.createActiveLeave(new ActiveLeave(appliedOn, startsOn, endsOn, numberOfDaysApplied, typeOfLeave,  leavaAddress, employeeId, supervisorId));
		if(status == true) {
			modelAndView.setViewName("index.jsp");
		}
		return modelAndView;
	}
}
