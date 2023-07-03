package com.Projects.TwitterApi.model;

import java.sql.Timestamp;

import com.sun.istack.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name = "tweet")
public class Tweet {
	
	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	private String tweetId;
	private String userId;
	private String userName;
	private String Content;
	private Timestamp timestamp;
	
	
	public Tweet() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Tweet(int id, String tweetId, String userId, String content, Timestamp timestamp) {
		super();
		this.id = id;
		this.tweetId = tweetId;
		this.userId = userId;
		Content = content;
		this.timestamp = timestamp;
	}


	
	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTweetId() {
		return tweetId;
	}


	public void setTweetId(String tweetId) {
		this.tweetId = tweetId;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getContent() {
		return Content;
	}


	public void setContent(String content) {
		Content = content;
	}


	public Timestamp getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	
	
	
	
}
