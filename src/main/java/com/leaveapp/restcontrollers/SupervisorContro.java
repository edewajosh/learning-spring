package com.leaveapp.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leaveapp.dao.SupervisorImplDao;
import com.leaveapp.models.Supervisor;

@RestController
@RequestMapping("/apiv1/supervisors")
public class SupervisorContro {
	
	@Autowired
	private SupervisorImplDao supervisorImplDao;
	
	// GET: fetch all supervisors
	@GetMapping("")
	public ResponseEntity<List<Supervisor>> getSupervisors(){
		List<Supervisor> supervisors = null;
		supervisors = supervisorImplDao.getAllSupervisors();
		return new ResponseEntity<List<Supervisor>>(supervisors, HttpStatus.OK);
	}
	
	// GET: fetch a single supervisor
	@GetMapping("/{id}")
	public ResponseEntity<Supervisor> getSupervisor(@PathVariable("id") int id){
		Supervisor supervisor = null;
		supervisor = supervisorImplDao.getSupervisorById(id);
		if(supervisor == null) {
			return new ResponseEntity<Supervisor>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Supervisor>(supervisor, HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Supervisor> createSupervisor(@RequestBody Supervisor supervisor){
		boolean status = false;
		status = supervisorImplDao.createSupervisor(supervisor);
		if(status == false) {
			return new ResponseEntity("Supervisor could not be created", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Supervisor>(supervisor, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteSupervisor(@PathVariable("id") int id){
		boolean status = false;
		status = supervisorImplDao.deleteSupervisorById(id);
		if(status == false) {
			return new ResponseEntity("Supervisor could not be deleted", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity("Supervisor deleted successfully", HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Supervisor> updateSupervisor(@PathVariable("id") int id, @RequestBody Supervisor supervisor){
		boolean status = false;
		status = supervisorImplDao.updateSupervisor(supervisor);
		if(status == false) {
			return new ResponseEntity<Supervisor>(supervisor, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Supervisor>(supervisor, HttpStatus.OK);
	}

}
