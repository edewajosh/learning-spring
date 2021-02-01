package com.kra.user.utils;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
/*
 * Class for creating an instance of SqlSessionFactory from XML 
 * configuration file
 */
public class BlogUtil {
	private static SqlSessionFactory factory;
	
	private BlogUtil() {}
	
	static {
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader("blog-config.xml");
		}catch(IOException e) {
			throw new RuntimeException(e.getMessage());
		}
		factory = new SqlSessionFactoryBuilder().build(reader);
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return factory;
	}
}
