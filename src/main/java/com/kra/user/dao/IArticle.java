package com.kra.user.dao;

import java.util.List;

import com.kra.article.model.Article;

public interface IArticle {
	public boolean createArticle(Article article);
	public Article getArticleById(int articleId);
	public List<Article> getAllArticles();
	public boolean updateArticle(Article article);
	public boolean deleteById(int articleId);
	public boolean deleteAllAricles();
	

}
