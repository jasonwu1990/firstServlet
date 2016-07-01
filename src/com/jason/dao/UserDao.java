package com.jason.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jason.bean.UserBean;
import com.jason.test.DbUtil;

public class UserDao implements IUserDao{
	
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

	@Override
	public void updateUser(UserBean user) {
		String sql = "update user set username=?, password=?";
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

	@Override
	public void delete(UserBean user) {
		String sql = "delete from user where vid=?";
	    Connection conn = null;  
	    PreparedStatement pstmt = null;  
	    try {  
	        conn = DbUtil.getConnection();  
	        pstmt = conn.prepareStatement(sql);  
	        pstmt.setInt(1, user.getVid());
	        pstmt.executeUpdate();  
	    }catch(SQLException e) {  
	        e.printStackTrace();  
	    }finally {  
	        DbUtil.close(pstmt);  
	        DbUtil.close(conn);  
	    }
	}

	@Override
	public List<UserBean> getInfo() {
		String sql = "select * from user";
		Connection conn = null;  
	    Statement stmt = null;  
	    List<UserBean> list = new ArrayList<UserBean> ();
	    try {  
	        conn = DbUtil.getConnection();  
	        stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);
	        
	        while(rs.next()) {
	        	UserBean user = new UserBean();
	        	user.setVid(rs.getInt(1));
	        	user.setUsername(rs.getString(2));
	        	user.setPassword(rs.getString(3));
	        	list.add(user);
	        }
	    }catch(SQLException e) {  
	        e.printStackTrace();  
	    }finally {  
	        DbUtil.close(conn);  
	    }
	    return list;
	}
	
//	public static void main(String args[]) {
//		UserBean user = new UserBean();
//		user.setUsername("wufan");
//		user.setPassword("123432");
//		UserDao dao = new UserDao();
//		dao.addUser(user);
//	}
}
