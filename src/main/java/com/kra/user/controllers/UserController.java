package com.kra.user.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.kra.user.dao.UserDaoImpl;
import com.kra.user.model.User;

@RestController
public class UserController {
	@Autowired
	private UserDaoImpl userDao;

	private ModelAndView mv = new ModelAndView();

	@RequestMapping("/save-user")
	public ModelAndView saveUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = 0;
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		boolean status = false;
		List<User> users = null;

		status = userDao.insert(new User(id, name, email));
		if (status == true) {
			users = userDao.getAll();
			mv.setViewName("index.jsp");
			mv.addObject("users", users);
			System.out.println("Success");
		} else {
			users = userDao.getAll();
			mv.setViewName("index.jsp");
			mv.addObject("users", users);
			System.out.println("Failed");
		}
		return mv;
	}
	
	@RequestMapping("/update")
	public ModelAndView updateUser(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String email = request.getParameter("email");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		boolean status = false;
		
		List<User> users = null;
		
		status = userDao.update(new User(id, name, email));
		if(status == true) {
			users = userDao.getAll();
			mv.setViewName("index.jsp");
			mv.addObject("users", users);
			System.out.println("Success");
		}else {
			users = userDao.getAll();
			mv.setViewName("index.jsp");
			mv.addObject("users", users);
			System.out.println("Failed");
		}
		return mv;
	}
	
	@RequestMapping("/delete-user")
	public ModelAndView deleteUser(HttpServletRequest request, HttpServletResponse response) throws Exception{
		boolean status = false;
		List<User> users = null;
		int id = Integer.parseInt(request.getParameter("id"));
		status = userDao.deleteUser(id);
		if(status == true) {
			mv.setViewName("index.jsp");
			mv.addObject("status", "deleted Successfully");
			users = userDao.getAll();
			mv.addObject("users", users);
		}else {
			mv.setViewName("index.jsp");
			mv.addObject("status", "not deleted");
			users = userDao.getAll();
			mv.addObject("users", users);
		}
		return mv;
	}
	
	@RequestMapping("/delete-users")
	public ModelAndView deleteAll(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		boolean status = false;
		
		status = userDao.deleteAll();
		if(status ==true) {
			mv.setViewName("index.jsp");
			mv.addObject("status", "deleted successfully");
		}else {
			mv.setViewName("index.jsp");
			mv.addObject("status", "deleted successfully");
		}
		return mv;
	}
	
	@RequestMapping("/users")
	public ModelAndView getAllUsers(HttpServletRequest request, HttpServletResponse response) throws Exception{
		List<User> users = userDao.getAll();
		mv.setViewName("index.jsp");
		mv.addObject("users", users);
		return mv;
	}
	
	@RequestMapping("/create-user")
	public ModelAndView createUser(HttpServletRequest request, HttpServletResponse response) throws Exception{
		mv.setViewName("create.jsp");
		return mv;
	}
	
	@RequestMapping("/update-user")
	public ModelAndView updateUserForm(HttpServletRequest request, HttpServletResponse response) throws Exception{
		boolean status = false;
		User user = null;
		int id = Integer.parseInt(request.getParameter("id"));
		user = userDao.getById(id);
		mv.setViewName("update.jsp");
		mv.addObject("user", user);
		return mv;
	}
}

