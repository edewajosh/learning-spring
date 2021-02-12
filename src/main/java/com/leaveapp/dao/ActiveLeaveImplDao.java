package com.leaveapp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.leaveapp.models.ActiveLeave;
import com.leaveapp.utils.LeaveUtils;

@Component
public class ActiveLeaveImplDao implements IActiveLeave {

	public boolean createActiveLeave(ActiveLeave activeLeave) {
		SqlSession session = LeaveUtils.getSqlSessionFactory().openSession();
		boolean status = false;
		try {
			session.insert("ActiveLeave.createActiveLeave", activeLeave);
			session.commit();
			status = true;
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public ActiveLeave getActiveLeaveById(Integer id) {
		return null;
	}

	public List<ActiveLeave> getAllActiveLeaves() {
		SqlSession session = LeaveUtils.getSqlSessionFactory().openSession();
		List<ActiveLeave> leaves = null;
		try {
			leaves = session.selectList("ActiveLeave.getAllActiveLeaves");
			session.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return leaves;
	}

	public boolean updateActiveLeave(ActiveLeave ActiveLeave) {
		return false;
	}

	public boolean deleteActiveLeaveById(int id) {
		return false;
	}

	public boolean deleteAllActiveLeaves() {
		return false;
	}

}
