package com.bj.impl;

import com.bj.entity.User;
import com.bj.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bj.dao.UserDao;

public class UserDaoImpl implements UserDao{

	boolean flag = false;
	
	private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    DbUtil db  = new DbUtil();
    private Connection conn = db.getConnection();
    
	@Override
	public boolean findLogin(User user){
		
		try{
			conn = db.getConnection();
			String sql = "select * from user where username=? and password=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPassWord());
			
			rs=pstmt.executeQuery();

			if(rs.next()){
				flag = true;
				user.setUserName(rs.getString("username"));
				user.setPassWord(rs.getString("password"));
			}
			
         	rs.close();
         	pstmt.close();
         	
		}catch(Exception e){
			e.printStackTrace();		
		}finally{
			db.closed();
		}
			System.out.println(flag+"=====UserDaoImpl");
			return flag;    
	}

	public boolean doInsert(User user) throws SQLException{
		conn = db.getConnection();
		String userName= user.getUserName();
		String passWord = user.getPassWord();
		String sql = "insert into user(id,username,password) values(?,userName,passWord)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userName);
		pstmt.setString(2, passWord);
		boolean flag =pstmt.execute();
		return flag;
	}
}
