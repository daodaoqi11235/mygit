package com.hibernate.beans;

// Generated 2016-8-22 10:31:49 by Hibernate Tools 3.4.0.CR1

/**
 * Administrator generated by hbm2java
 */
public class Administrator implements java.io.Serializable {

	private Integer administratorId;
	private String name;
	private String password;
	private int roleId;

	public Administrator() {
	}

	public Administrator(String name, String password, int roleId) {
		this.name = name;
		this.password = password;
		this.roleId = roleId;
	}

	public Integer getAdministratorId() {
		return this.administratorId;
	}

	public void setAdministratorId(Integer administratorId) {
		this.administratorId = administratorId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

}
