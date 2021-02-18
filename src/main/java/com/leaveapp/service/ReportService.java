package com.leaveapp.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.leaveapp.dao.ActiveLeaveImplDao;
import com.leaveapp.models.ActiveLeave;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Component
@Service
public class ReportService {
	
	@Autowired
	private ActiveLeaveImplDao activeLeaveDao;
	
	public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
		
		String path = "C:\\Users\\josh\\Desktop\\Report";
		List<ActiveLeave> leaves = activeLeaveDao.getAllActiveLeaves();
		
		// load file and compile it
		File file = ResourceUtils.getFile("classpath: jasperreport/leave.jrxml");
		
		JasperReport jasperReport =JasperCompileManager.compileReport(file.getAbsolutePath());
		
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(leaves);
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("createdBy", "Joshua Edewa");
		
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		
		if(reportFormat.equalsIgnoreCase("html")) {
			JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\leave.html");
		}
		if(reportFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\leave.pdf");
		}
		return "Report generated in path: " + path;
	}

}
