package com.kra.article.model;

import java.sql.Date;
import java.util.List;

import com.kra.user.model.User;

public class Article {
	private int id;
	private String title;
	private String body;
	private String createdOn;
	private List<User> user;
	
	public Article(String title, String body, String createdOn, List<User> user) {
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

	public List<User> getUsers() {
		return user;
	}

	public void setUsers(List<User> user) {
		this.user = user;
	}
	
	
}
