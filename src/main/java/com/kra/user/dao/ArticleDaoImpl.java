package com.kra.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kra.article.model.Article;
import com.kra.user.utils.BlogUtil;

public class ArticleDaoImpl implements IArticle {

	public boolean createArticle(Article article) {
		boolean status = false;
		SqlSession session = BlogUtil.getSqlSessionFactory().openSession();
		try {
			session.insert("Article.createAddress", article);
			session.commit();
			status = true;
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public Article getArticleById(int articleId) {
		Article article = null;
		SqlSession session = BlogUtil.getSqlSessionFactory().openSession();
		try {
			article = session.selectOne("Article.getArticleById", articleId);
			session.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return article;
	}

	public List<Article> getAllArticles() {
		List<Article> articles = null;
		SqlSession session = BlogUtil.getSqlSessionFactory().openSession();
		try {
			articles = session.selectList("Article.getAllArticles");
			session.commit();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return articles;
	}

	public boolean updateArticle(Article article) {
		boolean status = false;
		SqlSession session = BlogUtil.getSqlSessionFactory().openSession();
		try {
			session.insert("Article.updateArticle", article);
			session.commit();
			status = true;
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public boolean deleteById(int articleId) {
		boolean status = false;
		SqlSession session = BlogUtil.getSqlSessionFactory().openSession();
		try {
			session.insert("Article.deleteArticleById", articleId);
			session.commit();
			status = true;
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public boolean deleteAllAricles() {
		boolean status = false;
		SqlSession session = BlogUtil.getSqlSessionFactory().openSession();
		try {
			session.insert("Article.deleteAllArticles");
			session.commit();
			status = true;
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
