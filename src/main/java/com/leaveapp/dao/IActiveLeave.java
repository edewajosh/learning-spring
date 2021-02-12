package com.leaveapp.dao;

import java.util.List;

import com.leaveapp.models.ActiveLeave;

public interface IActiveLeave {
	public boolean createActiveLeave(ActiveLeave activeLeave);
	public ActiveLeave getActiveLeaveById(Integer id);
	public List<ActiveLeave> getAllActiveLeaves();
	public boolean updateActiveLeave(ActiveLeave ActiveLeave);
	public boolean deleteActiveLeaveById(int id);
	public boolean deleteAllActiveLeaves();
}
