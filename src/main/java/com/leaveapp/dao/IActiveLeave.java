package com.leaveapp.dao;

import java.util.List;

import com.leaveapp.models.ActiveLeave;

public interface IActiveLeave {
	public boolean createActiveLeave(ActiveLeave activeLeave);
	public List<ActiveLeave> getActiveLeaveBySupervisorId(Integer supervisor_id);
	public List<ActiveLeave> getActiveLeaveByEmployeeId(Integer employeeId);
	public List<ActiveLeave> getAllActiveLeaves();
	public ActiveLeave getLeaveById(Integer id);
	public boolean updateActiveLeave(ActiveLeave ActiveLeave);
	public boolean deleteActiveLeaveById(int id);
	public boolean deleteAllActiveLeaves();
}
