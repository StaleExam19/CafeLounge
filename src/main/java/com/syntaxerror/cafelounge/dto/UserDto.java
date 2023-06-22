package com.syntaxerror.cafelounge.dto;

import java.util.Date;

public class UserDto {

	private int id;
	private String username;
	private String password;
	private Date dateUpdated;
	
	
	// Setters
	public void setId(int id) {
		this.id = id;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	
	// Getters
	public int getId() {
		return this.id;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public Date getDateUpdated() {
		return this.dateUpdated;
	}
		
}