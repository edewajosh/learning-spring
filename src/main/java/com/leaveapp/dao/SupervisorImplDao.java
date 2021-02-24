package com.leaveapp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.leaveapp.models.Supervisor;
import com.leaveapp.utils.LeaveUtils;

@Component
public class SupervisorImplDao implements ISupervisor {

	public boolean createSupervisor(Supervisor supervisor) {
		SqlSession session = LeaveUtils.getSqlSessionFactory().openSession();
		boolean status = false;
		try {
			session.insert("Supervisor.createSupervisor", supervisor);
			session.commit();
			status = true;
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public Supervisor getSupervisorById(Integer id) {
		SqlSession session = LeaveUtils.getSqlSessionFactory().openSession();
		Supervisor supervisor = null;
		try {
			supervisor = session.selectOne("Supervisor.getSupervisorById", id);
			session.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return supervisor;
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

	public boolean updateSupervisor(Supervisor supervisor) {
		SqlSession session = LeaveUtils.getSqlSessionFactory().openSession();
		boolean status = false;
		try {
			session.update("Supervisor.updateSupervisor", supervisor);
			session.commit();
			status = true;
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public boolean deleteSupervisorById(int id) {
		SqlSession session = LeaveUtils.getSqlSessionFactory().openSession();
		boolean status = false;
		try {
			session.delete("Supervisor.deleteSupervisorById", id);
			session.commit();
			status = true;
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public boolean deleteAllSupervisors() {
		SqlSession session = LeaveUtils.getSqlSessionFactory().openSession();
		boolean status = false;
		try {
			session.delete("Supervisor.deleteAllSupervisors");
			session.commit();
			status = true;
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public Supervisor getSupervisorByEmail(String email) {
		SqlSession session = LeaveUtils.getSqlSessionFactory().openSession();
		Supervisor supervisor = null;
		try {
			supervisor = session.selectOne("Supervisor.getAllSupervisorByEmail", email);
			session.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return supervisor;
	}

}
