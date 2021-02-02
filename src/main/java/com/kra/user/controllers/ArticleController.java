package com.kra.user.controllers;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kra.article.model.Article;
import com.kra.user.dao.ArticleDaoImpl;
import com.kra.user.dao.UserDaoImpl;
import com.kra.user.model.User;

@Controller
public class ArticleController {

	@Autowired
	private ArticleDaoImpl articleDao;

	@Autowired
	private UserDaoImpl userDao;

	ModelAndView mv = new ModelAndView();

	@RequestMapping("/save-article")
	public ModelAndView createArticle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String title = request.getParameter("title");
		String body = request.getParameter("body");
		Integer author_id = Integer.parseInt(request.getParameter("author_id"));

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String createdOn = dtf.format(now);
		boolean status = false;
		List<Article> articles = null;
		List<User> users = null;

		status = articleDao.createArticle(new Article(title, body, createdOn, users));
		if (status == true) {
			mv.setViewName("articles.jsp");
			articles = articleDao.getAllArticles();
			System.out.println("Sucess");
			mv.addObject("articles", articles);
		} else {
			mv.setViewName("articles.jsp");
			articles = articleDao.getAllArticles();
			System.out.println("Failed");
			mv.addObject("articles", articles);
		}
		return mv;
	}
	
	@RequestMapping("/post-article")
	public ModelAndView postArticleForm() {
		mv.setViewName("post-article.jsp");
		return mv;
	}
}
