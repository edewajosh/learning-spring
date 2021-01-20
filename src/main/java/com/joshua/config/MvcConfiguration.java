/**
 * 
 */
package com.joshua.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.joshua.dao.ContactDAO;
import com.joshua.dao.ContactDAOImpl;

/**
 * @author Josh
 *
 */
@Configuration
@ComponentScan(basePackages="com.joshua")
@EnableWebMvc
public class MvcConfiguration implements WebMvcConfigurer {
	
	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/contactdb");
		dataSource.setUsername("root");
		dataSource.setPassword("10Password");
		return dataSource;
	}
	
	@Bean
	public ContactDAO getContactDAO() {
		return new ContactDAOImpl(getDataSource());
	}
}
