package com.leaveapp.dao;

import java.util.List;

import com.leaveapp.models.LeaveRecord;

public interface ILeaveRecord {
	public boolean createLeaveRecord(LeaveRecord leaveRecord);

	public LeaveRecord getLeaveRecordById(Integer id);

	public LeaveRecord getLeaveRecordByEmployeeId(int employeeId);

	public List<LeaveRecord> getAllLeaveRecords();

	public boolean updateLeaveRecord(LeaveRecord leaveRecord);

	public boolean deleteLeaveRecordById(int id);

	public boolean deleteAllLeaveRecords();
}
