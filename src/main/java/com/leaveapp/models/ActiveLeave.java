package com.leaveapp.models;

/*
 * @author: joshedewa@gmail.com
 * @version: 0.1.0
 * @since: 09-02-2021
 * 
 */

public class ActiveLeave {
	private Integer id;
	private LeaveRecord employee;
	private Integer employeeId;
	private String applied_on;
	private String started_on;
	private String ending_on;
	private Integer numberOfDaysApplied;
	private String typeOfLeave;
	private String comment;
	private Supervisor approvedBy;
	private Integer approvedById;
	private boolean isApproved;
	private String leaveAddress;
	private String status;
	
	// leave record
	
	
	public ActiveLeave() {}
	
	public ActiveLeave(Integer id, boolean isApproved) {
		this.id = id;
		this.isApproved = isApproved;
	}

	public ActiveLeave(String applied_on, String started_on, String ending_on, Integer numberOfDaysApplied,
			String typeOfLeave, String comment, boolean isApproved, String leaveAddress, Integer employeeId,
			Integer approvedById, String status) {
		this.applied_on = applied_on;
		this.started_on = started_on;
		this.ending_on = ending_on;
		this.numberOfDaysApplied = numberOfDaysApplied;
		this.typeOfLeave = typeOfLeave;
		this.comment = comment;
		this.isApproved = isApproved;
		this.leaveAddress = leaveAddress;
		this.employeeId = employeeId;
		this.approvedById = approvedById;
		this.status = status;
	}

	public ActiveLeave(String applied_on, String started_on, String ending_on, Integer numberOfDaysApplied,
			String typeOfLeave, String leaveAddress, Integer employeeId, Integer approvedById, String status) {
		this.applied_on = applied_on;
		this.started_on = started_on;
		this.ending_on = ending_on;
		this.numberOfDaysApplied = numberOfDaysApplied;
		this.typeOfLeave = typeOfLeave;
		this.leaveAddress = leaveAddress;
		this.employeeId = employeeId;
		this.approvedById = approvedById;
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LeaveRecord getEmployee() {
		return employee;
	}

	public void setEmployee(LeaveRecord employee) {
		this.employee = employee;
	}

	public String getApplied_on() {
		return applied_on;
	}

	public void setApplied_on(String applied_on) {
		this.applied_on = applied_on;
	}

	public String getStarted_on() {
		return started_on;
	}

	public void setStarted_on(String started_on) {
		this.started_on = started_on;
	}

	public String getEnded_on() {
		return ending_on;
	}

	public void setEnded_on(String ending_on) {
		this.ending_on = ending_on;
	}

	public Integer getNumberOfDaysApplied() {
		return numberOfDaysApplied;
	}

	public void setNumberOfDaysApplied(Integer numberOfDaysApplied) {
		this.numberOfDaysApplied = numberOfDaysApplied;
	}

	public String getTypeOfLeave() {
		return typeOfLeave;
	}

	public void setTypeOfLeave(String typeOfLeave) {
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

	public boolean getIsApproved() {
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

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getApproveById() {
		return approvedById;
	}

	public void setApprovedById(Integer approvedById) {
		this.approvedById = approvedById;
	}

}
