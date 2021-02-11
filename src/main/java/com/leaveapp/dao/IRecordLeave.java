package com.leaveapp.dao;

import java.util.List;

import com.leaveapp.models.LeaveRecord;

public interface IRecordLeave {
	public boolean createLeaveRecord(LeaveRecord leaveRecord);

	public LeaveRecord getLeaveRecordById(LeaveRecord LeaveRecord);

	public List<LeaveRecord> getAllLeaveRecords();

	public boolean updateLeaveRecord(LeaveRecord LeaveRecord);

	public boolean deleteLeaveRecordById(int id);

	public boolean deleteAllLeaveRecords();
}
