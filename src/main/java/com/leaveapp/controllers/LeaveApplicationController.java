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
import com.leaveapp.dao.LeaveRecordImplDao;
import com.leaveapp.dao.SupervisorImplDao;
import com.leaveapp.models.ActiveLeave;
import com.leaveapp.models.Employee;
import com.leaveapp.models.LeaveRecord;
import com.leaveapp.models.Supervisor;

@Controller
public class LeaveApplicationController {

	@Autowired
	private EmployeeImplDao employeeDao;

	@Autowired
	private ActiveLeaveImplDao activeLeaveDao;

	@Autowired
	private SupervisorImplDao supervisorDao;

	@Autowired
	private LeaveRecordImplDao leaveRecordDao;

	ModelAndView modelAndView = new ModelAndView();

	@RequestMapping("/leave-form")
	public ModelAndView searchStaffId(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer staff_id = Integer.parseInt(request.getParameter("staff_id").trim());
		String message = null;
		Employee employee = employeeDao.getEmployeeById(staff_id);
		List<Supervisor> supervisors = supervisorDao.getAllSupervisors();
		List<ActiveLeave> leaves = activeLeaveDao.getActiveLeaveByEmployeeId(staff_id);
		if (employee == null) {
			message = "Employee with that ID does not exist, please try again";
			modelAndView.setViewName("leave.jsp");
			modelAndView.addObject("message", message);
			return modelAndView;
		} else {
			modelAndView.addObject("employee", employee);
			modelAndView.addObject("supervisors", supervisors);
			modelAndView.addObject("leaves", leaves);
			modelAndView.setViewName("application-form.jsp");
			return modelAndView;
		}
	}

	@RequestMapping("/leave-request")
	public ModelAndView applyLeave(HttpServletRequest request, HttpServletResponse response) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date today = new Date();
		String appliedOn = format.format(today);
		String startsOn = request.getParameter("starts_on");
		String endsOn = request.getParameter("starts_on");
		String leave_status = "Pending";

		Integer numberOfDaysApplied = Integer.parseInt(request.getParameter("leave_days_applied"));
		String typeOfLeave = request.getParameter("type_of_leave");
		String leavaAddress = request.getParameter("leave_address");
		Integer employeeId = Integer.parseInt(request.getParameter("employee_id"));

		Integer supervisorId = Integer.parseInt(request.getParameter("supervisor_id"));

		LeaveRecord leaveRecord = null;
		leaveRecord = leaveRecordDao.getLeaveRecordByEmployeeId(employeeId);

		Integer totalRemainingLeaveDays = leaveRecord.getRemainingLeaveDays();
		String message = null;

		boolean status = false;

		if (typeOfLeave.equals("annual")) {
			if (totalRemainingLeaveDays > 0 && totalRemainingLeaveDays >= numberOfDaysApplied) {
				status = activeLeaveDao.createActiveLeave(new ActiveLeave(appliedOn, startsOn, endsOn,
						numberOfDaysApplied, typeOfLeave, leavaAddress, employeeId, supervisorId, leave_status));
				
				System.out.println("Leave was created succesful");
				
				// update the number of remaining leave days
				/**
				* System.out.println("Email: " + leaveRecord.getEmail() );
				* leaveRecord.setRemainingLeaveDays(remainingDays);
				* leaveRecordDao.updateLeaveRecord(leaveRecord);
				**/
				message = "Leave was applied successfully";
				modelAndView.addObject("status", status);
				modelAndView.addObject("message", message);
			} else {
				System.out.println("Leave could not be created");
				message = "Leave could not be created, you do not qualify ";
				modelAndView.addObject("message", message);
				modelAndView.setViewName("leave.jsp");
			}
		} else {
			status = activeLeaveDao.createActiveLeave(new ActiveLeave(appliedOn, startsOn, endsOn, numberOfDaysApplied,
					typeOfLeave, leavaAddress, employeeId, supervisorId, leave_status));
			System.out.println("Non-Annual Leave was created");
			modelAndView.setViewName("leave.jsp");
		}
		return modelAndView;
	}

	@RequestMapping("/delete-leave")
	public ModelAndView deleteLeave(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer id = Integer.parseInt(request.getParameter("id"));
		boolean status = false;

		status = activeLeaveDao.deleteActiveLeaveById(id);
		List<ActiveLeave> leaves = activeLeaveDao.getAllActiveLeaves();
		List<Employee> employees = employeeDao.getAllEmployees();
		if (status == true) {
			modelAndView.setViewName("dashboard.jsp");
			modelAndView.addObject("leaves", leaves);
			modelAndView.addObject("employees", employees);
			System.out.println("Deletion was successful");
		} else {
			modelAndView.setViewName("dashboard.jsp");
			modelAndView.addObject("leaves", leaves);
			modelAndView.addObject("employees", employees);
			System.out.println("Could not delete");
		}
		return modelAndView;
	}

	public LeaveRecord updateLeaveRecord(Integer id, int daysApplied) {
		LeaveRecord leaveRecord = null;
		leaveRecord = leaveRecordDao.getLeaveRecordByEmployeeId(id);
		Integer remainingDays = leaveRecord.getRemainingLeaveDays() - daysApplied;
		if (remainingDays <= 0) {
			System.out.println("Do not qualify for leave days");
		}
		return leaveRecord;
	}
}
