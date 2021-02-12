package com.leaveapp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.leaveapp.models.Supervisor;
import com.leaveapp.utils.LeaveUtils;

@Component
public class SupervisorImplDao implements ISupervisor {

	public boolean createSupervisor(Supervisor Supervisor) {
		return false;
	}

	public Supervisor getSupervisorById(Integer id) {
		return null;
	}

	public List<Supervisor> getAllSupervisors() {
		SqlSession session = LeaveUtils.getSqlSessionFactory().openSession();
		List<Supervisor> supervisors = null;
		try {
			supervisors = session.selectList("Supervisor.getAllSupervisors");
			session.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return supervisors;
	}

	public boolean updateSupervisor(Supervisor Supervisor) {
		return false;
	}

	public boolean deleteSupervisorById(int id) {
		return false;
	}

	public boolean deleteAllSupervisors() {
		return false;
	}

}
