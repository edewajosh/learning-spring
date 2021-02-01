package com.kra.article.model;

import java.sql.Date;

import com.kra.user.model.User;

public class Article {
	private int id;
	private String title;
	private String body;
	private String createdOn;
	private User user;
	
	public Article(String title, String body, String createdOn, User user) {
		this.title = title;
		this.body = body;
		this.createdOn = createdOn;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
