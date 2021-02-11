package com.leaveapp.utils;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class LeaveUtils {
	
private static SqlSessionFactory factory;
	
	private LeaveUtils() {}
	
	static {
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader("leave-app-config.xml");
		}catch(IOException e) {
			throw new RuntimeException(e.getMessage());
		}
		factory = new SqlSessionFactoryBuilder().build(reader);
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return factory;
	}
}
