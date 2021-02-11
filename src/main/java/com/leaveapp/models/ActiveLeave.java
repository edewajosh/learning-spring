package com.leaveapp.models;
/*
 * @author: joshedewa@gmail.com
 * @version: 0.1.0
 * @since: 09-02-2021
 * 
 */
import java.util.Date;

public class ActiveLeave {
	private Integer id;
	private Employee employee;
	private Date applied_on;
	private Date started_on;
	private Date ending_on;
	private Integer numberOfDaysApplied;
	private Integer typeOfLeave;
	private String comment;
	private Supervisor approvedBy;
	private boolean isApproved;
	private String leaveAddress;
	
	public ActiveLeave(Employee employee, Date applied_on, Date started_on, Date ending_on, Integer numberOfDaysApplied,
			Integer typeOfLeave, String comment, Supervisor approvedBy, boolean isApproved, String leaveAddress) {
		this.employee = employee;
		this.applied_on = applied_on;
		this.started_on = started_on;
		this.ending_on = ending_on;
		this.numberOfDaysApplied = numberOfDaysApplied;
		this.typeOfLeave = typeOfLeave;
		this.comment = comment;
		this.approvedBy = approvedBy;
		this.isApproved = isApproved;
		this.leaveAddress = leaveAddress;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Date getApplied_on() {
		return applied_on;
	}

	public void setApplied_on(Date applied_on) {
		this.applied_on = applied_on;
	}

	public Date getStarted_on() {
		return started_on;
	}

	public void setStarted_on(Date started_on) {
		this.started_on = started_on;
	}

	public Date getEnding_on() {
		return ending_on;
	}

	public void setEnding_on(Date ending_on) {
		this.ending_on = ending_on;
	}

	public Integer getNumberOfDaysApplied() {
		return numberOfDaysApplied;
	}

	public void setNumberOfDaysApplied(Integer numberOfDaysApplied) {
		this.numberOfDaysApplied = numberOfDaysApplied;
	}

	public Integer getTypeOfLeave() {
		return typeOfLeave;
	}

	public void setTypeOfLeave(Integer typeOfLeave) {
		this.typeOfLeave = typeOfLeave;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Supervisor getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(Supervisor approvedBy) {
		this.approvedBy = approvedBy;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	public String getLeaveAddress() {
		return leaveAddress;
	}

	public void setLeaveAddress(String leaveAddress) {
		this.leaveAddress = leaveAddress;
	}
	
	
}
