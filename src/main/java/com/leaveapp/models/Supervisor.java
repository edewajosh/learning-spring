package com.leaveapp.models;
/*
 * @author: joshedewa@gmail.com
 * @version: 0.1.0
 * @since: 09-02-2021
 * 
 */
public class Supervisor extends Employee{
	
	private boolean isSupervisor;
	private String email;
	
	public Supervisor(Integer id, String fullNames, String staffIdNo, String phoneNumber, String email) {
		super(id, fullNames, staffIdNo, phoneNumber);
		this.isSupervisor = true;
		this.email = email;
	}
	
	public Supervisor(String fullNames, String staffIdNo, String phoneNumber, boolean isSupervisor, String email) {
		super(fullNames, staffIdNo, phoneNumber);
		this.isSupervisor = true;
		this.email = email;
	}
	public boolean isSupervisor() {
		return isSupervisor;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
