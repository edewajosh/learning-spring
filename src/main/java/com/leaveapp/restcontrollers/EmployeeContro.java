package com.leaveapp.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leaveapp.dao.EmployeeImplDao;
import com.leaveapp.models.Employee;

@RestController
@RequestMapping("/apiv1/employees/")
public class EmployeeContro {
	
	@Autowired
	private EmployeeImplDao employeeImplDao;
	
	// GET: Returns a list of all employees
	@GetMapping("")
	public ResponseEntity<List<Employee>> getEmployees(){
		List<Employee> employees = null;
		employees = employeeImplDao.getAllEmployees();
		if(employees == null) {
			return new ResponseEntity("Request returned no results", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}
	
	// GET: Returns a response with an employee
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") int id){
		Employee employee = null;
		employee = employeeImplDao.getEmployeeById(id);
		if(employee == null) {
			return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	// POST: Creates an employee and returns the employee
	@PostMapping("")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
		boolean status = false;
		status = employeeImplDao.createEmployee(employee);
		if(status == false) {
			return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
	}
	
	// PUT: Updates an employee and returns employee response
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee){
		boolean status = false;
		status = employeeImplDao.updateEmployee(employee);
		if(status == false) {
			return new ResponseEntity("Employee could not be updated", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

}
