package com.bj.dao;

import java.sql.SQLException;

import com.bj.entity.User;

public interface UserDao {
	
	public boolean findLogin(User user);
	
	public boolean doInsert(User user) throws SQLException;
	
}
