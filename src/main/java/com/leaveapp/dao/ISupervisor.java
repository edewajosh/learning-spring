package com.leaveapp.dao;

import java.util.List;

import com.leaveapp.models.Supervisor;

public interface ISupervisor {
	public boolean createSupervisor(Supervisor supervisor);
	public Supervisor getSupervisorById(Integer id);
	public Supervisor getSupervisorByEmail(String email);
	public List<Supervisor> getAllSupervisors();
	public boolean updateSupervisor(Supervisor supervisor);
	public boolean deleteSupervisorById(int id);
	public boolean deleteAllSupervisors();
}
