package com.leaveapp.models;
/*
 * @author: joshedewa@gmail.com
 * @version: 0.1.0
 * @since: 09-02-2021
 * 
 */
public class LeaveRecord {
	private Integer id;
	private Integer daysCarriedForward;
	private final Integer currentYearLeaveDays = 20;
	private Integer totalLeaveDays;
	private Integer remainingLeaveDays;
	private Employee employee;
	
	private ActiveLeave activeLeave;
	
	public LeaveRecord(Integer id, Integer daysCarriedForward, Integer totalLeaveDays, Employee employee) {
		this.id = id;
		this.daysCarriedForward = daysCarriedForward;
		this.totalLeaveDays = totalLeaveDays;
		this.employee = employee;
		this.getCurrentYearLeaveDays();
	}

	public LeaveRecord(Integer daysCarriedForward,  Integer totalLeaveDays, Employee employee) {
		this.daysCarriedForward = daysCarriedForward;
		this.totalLeaveDays = totalLeaveDays;
		this.employee = employee;
		this.getCurrentYearLeaveDays();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDaysCarriedForward() {
		return daysCarriedForward;
	}

	public void setDaysCarriedForward(Integer daysCarriedForward) {
		this.daysCarriedForward = daysCarriedForward;
	}

	public Integer getCurrentYearLeaveDays() {
		return currentYearLeaveDays;
	}

	public Integer getTotalLeaveDays() {
		return totalLeaveDays;
	}

	public void setTotalLeaveDays(Integer totalLeaveDays) {
		this.totalLeaveDays = totalLeaveDays;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public Integer getRemainingLeaveDays() {
		return remainingLeaveDays;
	}
	
	public void setRemainingLeaveDays() {
		this.remainingLeaveDays = totalLeaveDays - activeLeave.getNumberOfDaysApplied();
	}
}
