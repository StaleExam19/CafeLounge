package com.syntaxerror.cafelounge.model;

public class UserForm {
	private String username;
	private String password;
	private String confirmPassword;

	public UserForm() {
	}

	public UserForm(String username, String password, String confirmPassword) {
		this.username = username;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	// Getters

	public String getUsername() {
		return this.username;
	}

	public String getPassword() {
		return this.password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}
}
