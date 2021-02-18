package com.leaveapp.controllers;

import java.io.File;
import java.io.FileNotFoundException;
/*
 * @author: joshedewa@gmail.com
 * @version: 0.1.0
 * @since: 09-02-2021
 * 
 */
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.leaveapp.dao.ActiveLeaveImplDao;
import com.leaveapp.dao.EmployeeImplDao;
import com.leaveapp.models.ActiveLeave;
import com.leaveapp.models.Employee;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

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
		List<ActiveLeave> leaves = activeLeaveDao.getAllActiveLeaves();
		modelAndView.setViewName("dashboard.jsp");
		UUID uuid = UUID.randomUUID();
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

	@RequestMapping("/generate-leave-pdf/{format}")
	public String leaveReport(@PathVariable String format) throws FileNotFoundException, JRException {
		exportReport(format);
		return "redirect:/admin";
	}

	public String exportReport(String reportFormat) throws FileNotFoundException, JRException {

		String path = "C:\\Users\\josh\\Desktop\\Report";
		List<ActiveLeave> leaves = null;
		leaves = activeLeaveDao.getAllActiveLeaves();

		// load file and compile it
		File file = ResourceUtils.getFile("classpath:/jasperreport/leave.jrxml");

		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(leaves);

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("createdBy", "Joshua Edewa");

		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

		if (reportFormat.equalsIgnoreCase("html")) {
			JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\leave.html");
		}
		if (reportFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\leave-1.pdf");
		}
		return "Report generated in path: " + path;
	}
}
