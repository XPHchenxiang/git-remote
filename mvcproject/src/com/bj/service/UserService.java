package com.bj.service;

import com.bj.entity.User;
import com.bj.impl.UserDaoImpl;

public class UserService {
	
	UserDaoImpl dao = new UserDaoImpl();
	
	public  boolean login(User user){
				
		boolean flag = dao.findLogin(user);	
		System.out.println(flag+"====UserService");
		return flag;
	}

}
