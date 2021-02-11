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
	private Integer currentYearLeaveDays;
	private Integer totalLeaveDays;
	private Integer remainingLeaveDays;
	private Integer employeeId;
	
	public LeaveRecord(Integer id, Integer daysCarriedForward, Integer totalLeaveDays,Integer currentYearLeaveDays , Integer remainingLeaveDays, Integer employeeId) {
		this.id = id;
		this.daysCarriedForward = daysCarriedForward;
		this.totalLeaveDays = totalLeaveDays;
		this.employeeId = employeeId;
		this.currentYearLeaveDays = currentYearLeaveDays;
		this.remainingLeaveDays = remainingLeaveDays;
	}

	public LeaveRecord(Integer daysCarriedForward,  Integer totalLeaveDays,Integer currentYearLeaveDays, Integer remainingLeaveDays, Integer employeeId) {
		this.daysCarriedForward = daysCarriedForward;
		this.totalLeaveDays = totalLeaveDays;
		this.employeeId = employeeId;
		this.currentYearLeaveDays = currentYearLeaveDays;
		this.remainingLeaveDays = remainingLeaveDays;
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
	public void setCurrentYearLeaveDays(Integer currentYearLeaveDays) {
		this.currentYearLeaveDays = currentYearLeaveDays;
	}

	public Integer getTotalLeaveDays() {
		return totalLeaveDays;
	}

	public void setTotalLeaveDays(Integer totalLeaveDays) {
		this.totalLeaveDays = totalLeaveDays;
	}

	public Integer getEmployee() {
		return employeeId;
	}

	public void setEmployee(Integer employeeId) {
		this.employeeId = employeeId;
	}
	
	public Integer getRemainingLeaveDays() {
		return remainingLeaveDays;
	}
	
	public void setRemainingLeaveDays(int remainingLeaveDays) {
		this.remainingLeaveDays = remainingLeaveDays;
	}
}
