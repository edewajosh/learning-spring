package com.kra.user.controllers;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.kra.article.model.Article;
import com.kra.user.dao.ArticleDaoImpl;

@Controller
public class ArticleController {
	
	@Autowired
	private ArticleDaoImpl articleDao;
	
	ModelAndView mv = new ModelAndView();
	
	public ModelAndView createArticle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String title = request.getParameter("title");
		String body = request.getParameter("body");
		Integer author_id = Integer.parseInt(request.getParameter("author_id"));
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String createdOn = dtf.format(now);
		boolean status = false;
		List<Article> articles = null;
		
		//status = articleDao.createArticle(new Article(title, body, createdOn, author_id));
		return mv;
	}
}
