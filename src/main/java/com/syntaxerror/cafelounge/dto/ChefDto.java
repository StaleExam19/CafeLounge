package com.syntaxerror.cafelounge.dto;

import java.util.Date;

public class ChefDto {

	private int id;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private Date dateCreated;
	private Date dateUpdated;
	private Date dateDeleted;
	
	
	// Setters
	public void setId(int id) {
		this.id = id;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public void setDateDeleted(Date dateDeleted) {
		this.dateDeleted = dateDeleted;
	}
	
	// Getters
	public int getId() {
		return this.id;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}

	public Date getDateCreated() {
		return dateCreated;
	}
	
	public Date getDateUpdated() {
		return this.dateUpdated;
	}

	public Date getDateDeleted() {
		return dateDeleted;
	}
		
}