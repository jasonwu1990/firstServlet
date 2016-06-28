package com.jason.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jason.bean.UserBean;
import com.jason.test.DbUtil;

public class UserDao {
	
	public void addUser(UserBean user) {
	  String sql = "insert into user (username, password) " +  
	            " values (?, ?)";  
	    Connection conn = null;  
	    PreparedStatement pstmt = null;  
	    try {  
	        conn = DbUtil.getConnection();  
	        pstmt = conn.prepareStatement(sql);  
	        pstmt.setString(1, user.getUsername());  
	        pstmt.setString(2, user.getPassword());  
	        pstmt.executeUpdate();  
	    }catch(SQLException e) {  
	        e.printStackTrace();  
	    }finally {  
	        DbUtil.close(pstmt);  
	        DbUtil.close(conn);  
	    }
	}
	
	public static void main(String args[]) {
		UserBean user = new UserBean();
		user.setUsername("wufan");
		user.setPassword("123432");
		UserDao dao = new UserDao();
		dao.addUser(user);
	}
}
