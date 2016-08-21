package com.base.hibernate.dao;

public interface ILoginDAO {

	public abstract boolean isValid(String username, String password);

}