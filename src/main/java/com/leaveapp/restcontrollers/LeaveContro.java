package com.leaveapp.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leaveapp.dao.ActiveLeaveImplDao;
import com.leaveapp.models.ActiveLeave;

@RestController
@RequestMapping("/apiv1/leaves/")
public class LeaveContro {
	
	@Autowired
	private ActiveLeaveImplDao leaveDao;
	
	//GET: Returns all leaves
	@GetMapping("")
	public ResponseEntity<List<ActiveLeave>> getAllLeaves(){
		List<ActiveLeave> leaves = null;
		leaves = leaveDao.getAllActiveLeaves();
		if(leaves == null) {
			return new ResponseEntity("Request returned empty results", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<ActiveLeave>>(leaves, HttpStatus.OK);
	}
	
	//GET: Get a single leave
	@GetMapping("{id}")
	public ResponseEntity<ActiveLeave> getLeaveById(@PathVariable("id") int id){
		ActiveLeave leave = null;
		leave = leaveDao.getLeaveById(id);
		
		if(leave == null) {
			return new ResponseEntity("Request returned empty results", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ActiveLeave>(leave, HttpStatus.OK);
	}
	
	//GET: Get all leaves assigned to that supervisor
	@GetMapping("/supervisor/{supervisor-id}")
	public ResponseEntity<List<ActiveLeave>> getLeaveSupervisorId(@PathVariable("supervisor-id") int supervisor_id){
		List<ActiveLeave> leaves = null;
		leaves = leaveDao.getActiveLeaveBySupervisorId(supervisor_id);
		
		if(leaves == null) {
			return new ResponseEntity("Request returned empty results", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<ActiveLeave>>(leaves, HttpStatus.OK);
	}
	
	//GET: Get all leaves assigned to that employee
	@GetMapping("/employee/{employee-id}")
	public ResponseEntity<List<ActiveLeave>> getLeaveEmployeeId(@PathVariable("employee-id") int employeeId){
		List<ActiveLeave> leaves = null;
		leaves = leaveDao.getActiveLeaveByEmployeeId(employeeId);
		
		if(leaves == null) {
			return new ResponseEntity("Request returned empty results", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<ActiveLeave>>(leaves, HttpStatus.OK);
	}


}
