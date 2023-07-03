package com.Projects.TwitterApi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import com.sun.istack.*;

@Entity(name = "Users")
public class Users {

	@Id
	@GeneratedValue
	private int  id;
	
	@NotNull
	private String userId;
	private String userName;
	private String name;
	private String Gender;
	
	
	
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(int id, String userId, String userName, String name, String gender) {
		super();
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.name = name;
		Gender = gender;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	
	
	
	
}
