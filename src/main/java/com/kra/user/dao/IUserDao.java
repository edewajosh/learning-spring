package com.kra.user.dao;

import java.util.List;

import com.kra.user.model.User;

public interface IUserDao {
	public boolean insert(User user);
	
	public User getById(int id);
	
	public List<User> getAll();
	
	public boolean update(User user);
	
	public boolean deleteUser(int id);
	
	public boolean deleteAll();

}
