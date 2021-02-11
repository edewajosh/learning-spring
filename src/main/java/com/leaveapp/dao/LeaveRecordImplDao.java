package com.leaveapp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.leaveapp.models.LeaveRecord;
import com.leaveapp.utils.LeaveUtils;

@Component
public class LeaveRecordImplDao implements IRecordLeave {
	

	public boolean createLeaveRecord(LeaveRecord leaveRecord) {
		SqlSession session = LeaveUtils.getSqlSessionFactory().openSession();
		boolean status = false;
		try {
			session.insert("LeaveRecord.createLeaveRecord", leaveRecord);
			session.commit();
			status = true;
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public LeaveRecord getLeaveRecordById(LeaveRecord LeaveRecord) {
		return null;
	}

	public List<LeaveRecord> getAllLeaveRecords() {
		SqlSession session = LeaveUtils.getSqlSessionFactory().openSession();
		List<LeaveRecord> leaveRecords = null;
		
		try {
			leaveRecords = session.selectList("LeaveRecord.getAllLeaveRecords");
			session.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return leaveRecords;
	}

	public boolean updateLeaveRecord(LeaveRecord LeaveRecord) {
		return false;
	}

	public boolean deleteLeaveRecordById(int id) {
		return false;
	}

	public boolean deleteAllLeaveRecords() {
		return false;
	}

}
