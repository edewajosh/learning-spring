package com.leaveapp.models;
/*
 * @author: joshedewa@gmail.com
 * @version: 0.1.0
 * @since: 09-02-2021
 * 
 */
public class Supervisor extends Employee{
	
	private boolean isSupervisor;
	
	public Supervisor(Integer id, String fullNames, String staffIdNo, String phoneNumber, boolean isSupervisor) {
		super(id, fullNames, staffIdNo, phoneNumber);
		this.setSupervisor(isSupervisor);
	}
	
	public Supervisor(String fullNames, String staffIdNo, String phoneNumber, boolean isSupervisor) {
		super(fullNames, staffIdNo, phoneNumber);
		this.setSupervisor(isSupervisor);
	}
	public boolean isSupervisor() {
		return isSupervisor;
	}

	public void setSupervisor(boolean isSupervisor) {
		this.isSupervisor = isSupervisor;
	}
}
