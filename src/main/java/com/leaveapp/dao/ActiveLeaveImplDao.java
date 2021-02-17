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

	public List<ActiveLeave> getActiveLeaveBySupervisorId(Integer supervisor_id) {
		SqlSession session = LeaveUtils.getSqlSessionFactory().openSession();
		List<ActiveLeave> leaves = null;
		try {
			leaves = session.selectList("ActiveLeave.getAllActiveLeavesByStaffId", supervisor_id);
			session.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return leaves;
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
		boolean status = false;
		SqlSession session = LeaveUtils.getSqlSessionFactory().openSession();
		try {
			session.update("ActiveLeave.updateLeaveRequest", ActiveLeave);
			session.commit();
			status=true;
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public boolean deleteActiveLeaveById(int id) {
		boolean status = false;
		SqlSession session = LeaveUtils.getSqlSessionFactory().openSession();
		try {
			session.delete("ActiveLeave.deleteActiveLeaveById", id);
			session.commit();
			status=true;
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public boolean deleteAllActiveLeaves() {
		return false;
	}

	public ActiveLeave getLeaveById(Integer id) {
		SqlSession session = LeaveUtils.getSqlSessionFactory().openSession();
		ActiveLeave leave = null;
		try {
			leave = session.selectOne("ActiveLeave.getActiveLeaveById", id);
			session.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return leave;
	}

	public List<ActiveLeave> getActiveLeaveByEmployeeId(Integer employeeId) {
		SqlSession session = LeaveUtils.getSqlSessionFactory().openSession();
		List<ActiveLeave> leaves = null;
		try {
			leaves = session.selectList("ActiveLeave.getAllActiveLeavesByEmployeeId", employeeId);
			session.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return leaves;
	}

}
