package com.kra.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kra.user.model.User;
import com.kra.user.utils.BlogUtil;

public class UserDaoImpl implements IUserDao{

	public boolean insert(User user) {
		// TODO Auto-generated method stub
		boolean status = false;
		SqlSession session = BlogUtil.getSqlSessionFactory().openSession();
		
		try {
			session.insert("User.createUser", user);
			session.commit();
			status = true;
			session.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}

	public User getById(int id) {
		// TODO Auto-generated method stub
		User user = null;
		SqlSession session = BlogUtil.getSqlSessionFactory().openSession();
		
		try {
			user = session.selectOne("User.getUserById", id);
			session.commit();
			session.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

	public List<User> getAll() {
		// TODO Auto-generated method stub
		List<User> users = null;
		SqlSession session = BlogUtil.getSqlSessionFactory().openSession();
		
		try {
			users = session.selectList("User.getAllUsers");
			session.commit();
			session.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return users;
	}

	public boolean update(User user) {
		// TODO Auto-generated method stub
		boolean status = false;
		
		SqlSession session = BlogUtil.getSqlSessionFactory().openSession();
		
		try {
			session.update("User.updateUser", user);
			session.commit();
			status = true;
			session.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}

	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		boolean status = false;
		SqlSession session = BlogUtil.getSqlSessionFactory().openSession();
		
		try {
			session.delete("User.deleteUser", id);
			session.commit();
			status = true;
			session.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}

	public boolean deleteAll() {
		// TODO Auto-generated method stub
		boolean status = false;
		
		SqlSession session = BlogUtil.getSqlSessionFactory().openSession();
		
		try {
			session.delete("User.deleteAllUsers");
			session.commit();
			status = true;
			session.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}

}
