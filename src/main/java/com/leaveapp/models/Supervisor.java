package com.leaveapp.models;
/*
 * @author: joshedewa@gmail.com
 * @version: 0.1.0
 * @since: 09-02-2021
 * 
 */
public class Supervisor extends Employee{
	
	private boolean isSupervisor;
	private String password;
	
	public Supervisor() {}
	
	public Supervisor(Integer id, String fullNames, String staffIdNo, String phoneNumber, String email, String password) {
		super(id, fullNames, staffIdNo, phoneNumber, email);
		this.isSupervisor = true;
		this.password = password;
	}
	
	public Supervisor(String fullNames, String staffIdNo, String phoneNumber, boolean isSupervisor, String email, String password) {
		super(fullNames, staffIdNo, phoneNumber, email);
		this.isSupervisor = true;
		this.password = password;
	}
	
	public boolean isSupervisor() {
		return isSupervisor;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
