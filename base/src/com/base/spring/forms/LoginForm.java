package com.base.spring.forms;

public class LoginForm {
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		System.out.println("password");
		this.password = password;
	}
}
