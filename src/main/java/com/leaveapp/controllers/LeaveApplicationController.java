package com.leaveapp.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PathVariable;
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
import com.leaveapp.utils.LeaveUtils;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRAbstractBeanDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

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
		LeaveRecord employeeLeaveRecord = leaveRecordDao.getLeaveRecordByEmployeeId(staff_id);
		if (employee == null) {
			message = "Employee with that ID does not exist, please try again";
			modelAndView.setViewName("leave.jsp");
			modelAndView.addObject("message", message);
			return modelAndView;
		} else {
			modelAndView.addObject("employee", employee);
			modelAndView.addObject("supervisors", supervisors);
			modelAndView.addObject("leaves", leaves);
			modelAndView.addObject("record", employeeLeaveRecord);
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
	
	@RequestMapping("/employee-leave/{format}/{id}")
	public String downloadLeaveForm(@PathVariable String format, @PathVariable Integer id) throws Exception {
		exportReport(format, id);
		return "redirect: /leave-form";
	}
	
	public String exportReport(String reportFormat, Integer leaveId) throws FileNotFoundException, JRException {

		String path = "C:\\Users\\josh\\Desktop\\Report";
		// List<ActiveLeave> leaves = null;
		ActiveLeave leave = null;
		leave = activeLeaveDao.getLeaveById(leaveId);
		// System.out.println("LeaveId: " + leaveId + " Date Applied: " + leave.getApplied_on());
		// load file and compile it
		
		File file = ResourceUtils.getFile("classpath:/jasperreport/form_leave.jrxml");

		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

		// JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(leave);

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("createdBy", "Joshua Edewa");
		
		SqlSession session = LeaveUtils.getSqlSessionFactory().openSession();
		Connection connection = session.getConnection();

		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);

		if (reportFormat.equalsIgnoreCase("html")) {
			JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\leave.html");
		}
		if (reportFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\leave-form.pdf");
		}
		return "Report generated in path: " + path;
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
