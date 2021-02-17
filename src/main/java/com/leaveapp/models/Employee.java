package com.leaveapp.models;
/*
 * @author: joshedewa@gmail.com
 * @version: 0.1.0
 * @since: 09-02-2021
 * 
 */
public class Employee {
	private Integer id;
	private String fullNames;
	private String staffIdNo;
	private String phoneNumber;
	private String email;
	
	public Employee() {}
	
	public Employee(Integer id, String fullNames, String staffIdNo, String phoneNumber, String email) {
		this.id = id;
		this.fullNames = fullNames;
		this.staffIdNo = staffIdNo;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public Employee(String fullNames, String staffIdNo, String phoneNumber, String email) {
		this.fullNames = fullNames;
		this.staffIdNo = staffIdNo;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullNames() {
		return fullNames;
	}

	public void setFullNames(String fullNames) {
		this.fullNames = fullNames;
	}

	public String getStaffIdNo() {
		return staffIdNo;
	}

	public void setStaffIdNo(String staffIdNo) {
		this.staffIdNo = staffIdNo;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
